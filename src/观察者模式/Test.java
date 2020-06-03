package 观察者模式;

/**
 * @author: TangLiang
 * @date: 2020/5/28 17:35
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //创建一个主题
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer observer = new ConcreteObserver();
        //观察
        subject.addObserver(observer);
        //开始活动
        subject.doSomething();
    }
}
