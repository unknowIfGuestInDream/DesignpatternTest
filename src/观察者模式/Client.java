package 观察者模式;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: TangLiang
 * @date: 2020/12/3 9:56
 * @since: 1.0
 */
public class Client {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addObserver(new Listener());
        eventSource.print(1);
    }

    static class EventSource extends Observable {
        public void print(Integer integer) {
            setChanged();
            notifyObservers(integer);
        }
    }

    static class Listener implements Observer {
        public void update(Observable o, Object arg) {
            System.out.println(arg);
        }
    }


}
