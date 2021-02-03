package 原型.拷贝单例类;

/**
 * @author: TangLiang
 * @date: 2021/2/3 19:18
 * @since: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(DbUtil.getInstance());
        System.out.println(DbUtil.getInstance());
        DbUtil.getInstance().setDriver("aaa");
        DbUtil.getInstance().init();
        System.out.println(DbUtil.getInstance().clone());
        System.out.println(DbUtil.getInstance().clone());
    }
}
