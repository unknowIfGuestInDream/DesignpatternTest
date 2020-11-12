package 装饰;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:09
 * @since: 1.0
 */
public class Ring extends PhoneDecorate {
    public Ring(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        System.out.println("手机听彩铃");
        super.call();
    }
}
