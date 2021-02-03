package 原型.拷贝单例类;

/**
 * @author: TangLiang
 * @date: 2021/2/3 19:18
 * @since: 1.0
 */
public class Test2 {
    public static DbUtil oracle = DbUtil.getInstance();
    public static DbUtil mysql = (DbUtil) oracle.clone();
    public static DbUtil sqlserver = (DbUtil) oracle.clone();

    public static void main(String[] args) {
        System.out.println(oracle);
        System.out.println(mysql);

        DbUtil.getInstance().setDriver("aaa");
        System.out.println(oracle);
        System.out.println(sqlserver);
        System.out.println(DbUtil.getInstance().clone());
        System.out.println(DbUtil.getInstance().clone());
    }
}
