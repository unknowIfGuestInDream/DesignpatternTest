package 工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:32
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scrum1Factory scrum1Factory = new Scrum1Factory();
        Scrum scrum1 = scrum1Factory.createScrum();
        scrum1.selectScrum();

        Scrum2factory scrum2Factory = new Scrum2factory();
        Scrum scrum2 = scrum2Factory.createScrum();
        scrum2.selectScrum();
    }
}
