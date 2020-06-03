package 简单工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:22
 * @since: 1.0
 */
public class Scrum2 implements Scrum {
    @Override
    public int addScrum() {
        return 2;
    }

    @Override
    public int updateScrum() {
        return 2;
    }

    @Override
    public void selectScrum() {
        System.out.println("我是Scrum2");
    }
}
