package 观察者模式.Demo;

import 观察者模式.Demo1.Observer;

/**
 * 主题
 *
 * @author: TangLiang
 * @date: 2020/5/28 17:30
 * @since: 1.0
 */
public interface Subject {

    //增加
    public void attach(Observer observer);

    //删除
    public void detach(Observer observer);

    //通知
    public void notifyObservers();

    //状态
    public void setAction(String action);

    public String getAction();
}
