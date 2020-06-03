package 观察者模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 主题
 *
 * @author: TangLiang
 * @date: 2020/5/28 17:30
 * @since: 1.0
 */
public class Subject {
    //观察者数组
    //同步 安全
    private Vector<Observer> oVector = new Vector<>();
    //异步 不安全
    private List list = new ArrayList();

    //增加一个观察者
    public void addObserver(Observer observer) {
        this.oVector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        this.oVector.remove(observer);
    }

    //通知所有观察者
    public void notifyObserver() {
        for (Observer observer : this.oVector) {
            observer.update();
        }
    }
}
