package 观察者模式;

/**
 * 具体主题
 *
 * @author: TangLiang
 * @date: 2020/5/28 17:31
 * @since: 1.0
 */
public class ConcreteSubject extends Subject {
    //具体业务
    public void doSomething() {
        //...
        super.notifyObserver();
    }
}
