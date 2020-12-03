package 观察者模式.Demo1;

/**
 * 具体观察者
 *
 * @author: TangLiang
 * @date: 2020/5/28 17:33
 * @since: 1.0
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("收到消息，进行处理");
    }
}
