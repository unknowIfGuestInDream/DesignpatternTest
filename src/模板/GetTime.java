package 模板;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:06
 * @since: 1.0
 */
public abstract class GetTime {
    public long getTime() {
        long start = System.currentTimeMillis();
        this.code();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public abstract void code();
}
