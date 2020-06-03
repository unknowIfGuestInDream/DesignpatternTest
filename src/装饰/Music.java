package 装饰;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:08
 * @since: 1.0
 */
public class Music extends PhoneDecorate {
    public Music(Phone p) {
        super(p);
    }

    public void call() {
        super.call();
        System.out.println("听音乐");
    }
}
