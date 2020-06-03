package 模板;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:07
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        GetTime getTime = new ForDemo();
        System.out.println(getTime.getTime() + "毫秒");
        getTime = new IODemo();
        System.out.println(getTime.getTime() + "毫秒");
    }
}
