package 单例.枚举充当内部类;

/**
 * @author: TangLiang
 * @date: 2020/11/14 18:01
 * @since: 1.0
 */
public class Singleton {
    private byte[] dat = new byte[1024];

    private Singleton() {

    }

    //使用枚举类充当holder 增加懒加载特性
    private enum EnumHolder {
        INSTANCE;
        private Singleton instance;

        EnumHolder() {
            this.instance = new Singleton();
        }

        private Singleton getSingleton() {
            return instance;
        }
    }

    public static Singleton getInstance() {
        return EnumHolder.INSTANCE.getSingleton();
    }

}
