package 简单工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:20
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scrum scrum = ScrumFactory.creatScrum("Scrum1");
        scrum.selectScrum();
    }
}
