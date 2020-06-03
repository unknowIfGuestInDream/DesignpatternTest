package 工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:36
 * @since: 1.0
 */
public class Scrum2factory implements ScrumFactory {
    @Override
    public Scrum createScrum() {
        return new Scrum2();
    }
}
