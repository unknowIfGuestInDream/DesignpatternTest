package 装饰;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:08
 * @since: 1.0
 */
public abstract class PhoneDecorate implements Phone {
    private Phone p;

    public PhoneDecorate(Phone p) {
        this.p = p;
    }

    public void call() {
        this.p.call();
    }
}
