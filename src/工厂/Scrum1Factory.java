package 工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:35
 * @since: 1.0
 */
public class Scrum1Factory implements ScrumFactory {
    @Override
    public Scrum createScrum() {
        return new Scrum1();
    }
}
