package 算法.zip;

import java.util.*;

/**
 * Huffman编码
 */
public class HuffmanCode {
    public static void main(String[] args) {
//        String source = "i like like like java do you like a java";
        String source = "fdsafds afdsf dsfafdsgfdfsafdsa weew2131 32";
        //把字符串转为bytes数组,其中每个byte存储一个char,可以查询ASCII表
        byte[] sourceBytes = source.getBytes();
        //统计所有char出现的次数
        Map<Byte, Integer> map = countTimes(sourceBytes);
        //根据统计的出现次数构建一个Huffman树
        Node root = generateHuffmanTreeNode(map);
        //根据Huffman树获取不重复的路径编码  左为0  右为1,即是编码表
        Map<Byte, String> huffmanCode = getHuffmanCode(root);
        //按照Huffman编码进行压缩,生成编码后字符串
        String code = zip(source, huffmanCode);
        System.out.println("压缩后code:" + code);
        //我们需要记录编码后的长度，如果按照byte数组存储，最后一个byte有可能是0开头，这样就会丢失部分压缩后数据，导致不能解析
        int len = code.length();
        //将字符串截取存储到byte[],一个byte可以存储8位
        Byte[] bytes = convert(code);
        System.out.println("加密后得到:");
        System.out.println("加密后代码=" + Arrays.toString(bytes));
        System.out.println("长度=" + len);
        System.out.println("编码表=" + huffmanCode);
        //解码
        String str = decode(bytes, huffmanCode, len);
        System.out.println("解码后结果:" + str);
    }

    /**
     * 解码
     *
     * @param bytes       加密后代码
     * @param huffmanCode 编码表 key:字符 value:编码
     * @param len         加密后代码长度
     * @return
     */
    private static String decode(Byte[] bytes, Map<Byte, String> huffmanCode, int len) {
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

        System.out.println("解码后code:" + sb.toString());

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

        return new String(result);
    }

    /**
     * 1.java中变量都是以补码的形式保存的
     * 2.int 在java中是32位， byte是8位。
     * 3.原码，反码，补码简介
     * 原码：就是二进制码，最高位为符号位，0表示正数，1表示负数，剩余部分表示真值。
     * 反码：在原码的基础上，正数反码就是他本身，负数除符号位之外全部按位取反。
     * 补码：正数的补码就是自己本身， 负数的补码是在自身反码的基础上加1.
     */
    private static Byte[] convert(String code) {
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
                System.out.println("最后一个串：" + substring);
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

    /**
     * 压缩
     *
     * @param source
     * @param huffmanCode
     * @return
     */
    private static String zip(String source, Map<Byte, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = source.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(huffmanCode.get(bytes[i]));
        }
        return sb.toString();
    }

    private static Map<Byte, String> huffmanCode = new HashMap<>();

    private static Map<Byte, String> getHuffmanCode(Node root) {
        //这里使用中序遍历遍历Huffman树
        if (root.left != null) {
            getCode(root.left, "0", "");
        }
        if (root.right != null) {
            getCode(root.right, "1", "");
        }
        return huffmanCode;
    }

    private static void getCode(Node node, String str, String source) {
        source += str;
        //如果是叶子节点
        if (node.val != null) {
            huffmanCode.put(node.val, source);
        }
        if (node.left != null) {
            getCode(node.left, "0", source);
        }

        if (node.right != null) {
            getCode(node.right, "1", source);
        }
    }

    private static Node generateHuffmanTreeNode(Map<Byte, Integer> map) {
        List<Node> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getValue(), entry.getKey());
            list.add(node);
        }
        return buildHuffmanTree(list);
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

    //构建一个哈夫曼树
    private static Node buildHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序List
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.weight + right.weight, null);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    static class Node implements Comparable<Node> {

        public int weight;
        public Byte val;
        public Node left;
        public Node right;

        public Node(int weight, Byte val) {
            this.weight = weight;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    '}';
        }

        public void preOrder() {
            System.out.print(" " + weight + "[" + val + "] ");
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }
}
