package 观察者模式.Demo;

/**
 * 抽象观察者
 *
 * @author: TangLiang
 * @date: 2020/5/28 17:31
 * @since: 1.0
 */
public abstract class Observer {

    protected String name;
    protected Subject subject;

    public Observer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public abstract void update();

}
