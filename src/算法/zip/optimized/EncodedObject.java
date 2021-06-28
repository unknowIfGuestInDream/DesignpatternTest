package 算法.zip.optimized;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/**
 * 编码结果对象
 */
public class EncodedObject implements Serializable {
    /**
     * 编码表
     */
    private Map<Byte, String> huffmanCode;
    /**
     * 编码后字符串的长度
     */
    private int len;
    /**
     * 编码后编码
     */
    private Byte[] bytes;

    public EncodedObject() {
    }

    public EncodedObject(Map<Byte, String> huffmanCode, int len, Byte[] bytes) {
        this.huffmanCode = huffmanCode;
        this.len = len;
        this.bytes = bytes;
    }

    public Map<Byte, String> getHuffmanCode() {
        return huffmanCode;
    }

    public void setHuffmanCode(Map<Byte, String> huffmanCode) {
        this.huffmanCode = huffmanCode;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public Byte[] getBytes() {
        return bytes;
    }

    public void setBytes(Byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "EncodedObject{" +
                "huffmanCode=" + huffmanCode +
                ", len=" + len +
                ", bytes=" + Arrays.toString(bytes) +
                '}';
    }
}
