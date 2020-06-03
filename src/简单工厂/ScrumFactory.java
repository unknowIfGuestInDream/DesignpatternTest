package 简单工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:23
 * @since: 1.0
 */
public class ScrumFactory {
    public static Scrum creatScrum(String scrumName) {
        Scrum scrum = null;
        switch (scrumName) {
            case "Scrum1":
                scrum = new Scrum1();
                break;
            case "Scrum2":
                scrum = new Scrum2();
                break;
            default:
                scrum = null;
                break;
        }
        return scrum;
    }
}
