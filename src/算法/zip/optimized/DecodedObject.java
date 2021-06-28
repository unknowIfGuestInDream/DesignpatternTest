package 算法.zip.optimized;

import java.io.Serializable;
import java.util.Arrays;

public class DecodedObject implements Serializable {
    /**
     * 编码后编码
     */
    private byte[] bytes;

    public DecodedObject() {
    }

    public DecodedObject(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "DecodedObject{" +
                "bytes=" + Arrays.toString(bytes) +
                '}';
    }
}
