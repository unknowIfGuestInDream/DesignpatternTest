package 原型.demo1;

/**
 * @author: TangLiang
 * @date: 2021/2/3 19:06
 * @since: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Citation obj1 = new Citation();
        obj1.setName("hello");
        System.out.println(obj1);
        Citation obj2 = (Citation) obj1.clone();
        obj2.setInfo("world");
        System.out.println(obj2);
    }
}
