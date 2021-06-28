package 算法.zip.optimized;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimizedZipUtil {

    public static void zip(String path, String dst) {
        encode(new File(path), new File(dst));
    }

    public static void unzip(String path, String dst) {
        decode(new File(path), new File(dst));
    }

    public static void decode(File file, File dst) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
             FileOutputStream outputStream = new FileOutputStream(dst)) {
            Map<Byte, String> map = (Map<Byte, String>) inputStream.readObject();
            int len = (int) inputStream.readObject();
            Byte[] bytes = (Byte[]) inputStream.readObject();
            outputStream.write(decode(new EncodedObject(map, len, bytes)).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void encode(File file, File dst) {
        try (FileInputStream inputStream = new FileInputStream(file);
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dst))) {
            byte[] b = new byte[(int) file.length()];
            inputStream.read(b);
            EncodedObject encode = encode(b);
            outputStream.writeObject(encode.getHuffmanCode());
            outputStream.writeObject(encode.getLen());
            outputStream.writeObject(encode.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EncodedObject encode(String source) {
        return encode(source.getBytes());
    }

    public static String decodeToString(EncodedObject encodedObject) {
        DecodedObject decode = decode(encodedObject);
        return new String(decode.getBytes());
    }

    /**
     * 解码
     *
     * @param encodedObject
     * @return
     */
    public static DecodedObject decode(EncodedObject encodedObject) {
        Byte[] bytes = encodedObject.getBytes();
        Map<Byte, String> huffmanCode = encodedObject.getHuffmanCode();
        int len = encodedObject.getLen();
        //把bytes里面的所有元素拿出来,拼接成一个整串,如果考虑到性能,可以取一部分处理一部分
        StringBuilder sb = new StringBuilder();
        //这里考虑到最后一位数有可能是0开头,我们需要特殊处理,这里就处理到倒数第一个数
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i]; //这里将byte强转int,会在int的前3个字节全补上0
            //如果b是正数,那么就会省略前面的0,我们需要补充int的最后一个字节的所有0
            //这里我们使用二进制的"或" 例:1000 我们需要的值0000 1000
            //如果我们在左边再加1位:1 0000 1000,toBinaryString就不会省略了
            //这里只要 1000 | 1 0000 0000 = 1 0000 1000,1 0000 0000 转10进制是256;
            b = b | Integer.parseInt("100000000", 2);
            String s = Integer.toBinaryString(b);
            if (i == bytes.length - 1) {//如果是最后一个byte,则要考虑0开头的情况,如果0开头我们需要补齐
                int remaining = len - sb.length();
                sb.append(s.substring(s.length() - remaining));
            } else {
                sb.append(s.substring(s.length() - 8));
            }
        }

        Map<String, Byte> map = new HashMap<>();
        //因为解码是根据编码获取原字符,所以这里调整一下编码表,让key和value调换
        //这里的value是根据Huffman算法路径生成也是唯一的
        for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        List<Byte> resultList = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < sb.length(); i++) {
            //拼接当前元素
            temp += sb.charAt(i);
            //从编码表中获取对应的byte也就是字符
            Byte b = map.get(temp);
            if (b != null) {//匹配到了,存入result
                resultList.add(b);
                //清空temp
                temp = "";
            }//没匹配到就继续循环,往下继续取
        }

        byte[] result = new byte[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return new DecodedObject(result);
    }

    /**
     * 编码
     *
     * @param sourceBytes
     * @return
     */
    public static EncodedObject encode(byte[] sourceBytes) {
        System.out.println("压缩前字节长度:" + sourceBytes.length);
        //统计所有char出现的次数
        Map<Byte, Integer> map = countTimes(sourceBytes);
        Map<Byte, String> huffmanCode = new HuffmanHandler(map).generateHuffmanCode();

        //按照Huffman编码进行压缩,生成编码后字符串
        String code = zip(sourceBytes, huffmanCode);
        //我们需要记录编码后的长度，如果按照byte数组存储，最后一个byte有可能是0开头，这样就会丢失部分压缩后数据，导致不能解析
        int len = code.length();
        //将字符串截取存储到byte[],一个byte可以存储8位
        Byte[] bytes = convert(code);
        System.out.println("压缩后字节长度:" + bytes.length);
        System.out.println("记录长度字段3+编码表长度:" + (3 + huffmanCode.size()));
        return new EncodedObject(huffmanCode, len, bytes);
    }

    /**
     * 1.java中变量都是以补码的形式保存的
     * 2.int 在java中是32位， byte是8位。
     * 3.原码，反码，补码简介
     * 原码：就是二进制码，最高位为符号位，0表示正数，1表示负数，剩余部分表示真值。
     * 反码：在原码的基础上，正数反码就是他本身，负数除符号位之外全部按位取反。
     * 补码：正数的补码就是自己本身， 负数的补码是在自身反码的基础上加1.
     */
    public static Byte[] convert(String code) {
        //如果长度是9则,需要2位来存储,我们
        int len = (code.length() + (8 - 1)) / 8;
        Byte[] bytes = new Byte[len];
        int index = 0;
        for (int i = 0; i < code.length(); i += 8) {
            String substring = null;
            //如果当前下标,再往后推7个数,即是包括自己一共8个元素,得到的下标,超过字符串长度,说明已经到最后一个字节了
            if (i + 7 > code.length() - 1) {
                //最后一个字节,切割到最后
                substring = code.substring(i);
            } else {
                //不是最后一个字节,都是满8位的
                substring = code.substring(i, i + 8);
            }
            //将二进制字符串解析成Integer(32位,4个字节)
            int intVal = Integer.parseInt(substring, 2);
            //这里强转,直接舍弃前面3个字节,只留下最后一个字节
            bytes[index++] = (byte) intVal;
        }
        return bytes;
    }

    public static Map<Byte, Integer> countTimes(byte[] bytes) {
        Map<Byte, Integer> map = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            Integer times = map.get(bytes[i]);
            //如果没有统计过,则初始化times为0次
            if (times == null) {
                times = 0;
            }
            //统计次数+1
            times++;
            //放入map,如果已经存在会覆盖
            map.put(bytes[i], times);
        }
        return map;
    }

    /**
     * 压缩
     *
     * @param bytes
     * @param huffmanCode
     * @return
     */
    private static String zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(huffmanCode.get(bytes[i]));
        }
        return sb.toString();
    }
}
