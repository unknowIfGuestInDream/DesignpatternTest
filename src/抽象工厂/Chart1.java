package 抽象工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 13:35
 * @since: 1.0
 */
public class Chart1 implements Chart {
    @Override
    public void selectChart() {
        System.out.println("我是Chart1");
    }
}
