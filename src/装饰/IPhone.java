package 装饰;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:09
 * @since: 1.0
 */
public class IPhone implements Phone {
    @Override
    public void call() {
        System.out.println("打电话");
    }
}
