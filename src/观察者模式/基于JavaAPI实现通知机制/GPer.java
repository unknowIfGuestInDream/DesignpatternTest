package 观察者模式.基于JavaAPI实现通知机制;

import java.util.Observable;

/**
 * 被观察者
 *
 * @author: TangLiang
 * @date: 2020/12/3 11:06
 * @since: 1.0
 */
public class GPer extends Observable {

    private String name = "GPer论坛";
    private static GPer gper = null;

    private GPer() {
    }

    public static GPer getInstance() {
        if (null == gper) {
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。 ");
        setChanged();
        notifyObservers(question);
    }
}
