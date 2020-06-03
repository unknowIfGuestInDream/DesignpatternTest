package 装饰;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:09
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Phone p = new IPhone();
        p.call();
        System.out.println("--------");
        PhoneDecorate pc = new Ring(p);
        pc.call();
        System.out.println("--------");
        pc = new Music(p);
        pc.call();
        System.out.println("--------");
        pc = new Ring(new Music(p));
        pc.call();
    }
}
