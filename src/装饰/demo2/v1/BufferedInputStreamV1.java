package 装饰.demo2.v1;

import 装饰.demo2.MyInputStream;

/**
 * @author: tangliang
 * @date: 2020/3/30 13:32.
 * @description: XXX
 */
public class BufferedInputStreamV1 extends MyInputStream {

    protected volatile MyInputStream inputStream;

    public BufferedInputStreamV1(MyInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() {
        System.out.println("重写带缓存的方法读");
        inputStream.read("s");
        return 1;
    }

    @Override
    public int reset() {
        System.out.println("重写带缓存的方法重置");
        inputStream.read("s");
        return 0;
    }
}
