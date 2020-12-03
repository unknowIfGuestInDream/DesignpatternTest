package 观察者模式.基于JavaAPI实现通知机制;

import java.util.Observable;
import java.util.Observer;

/**
 * 老师
 *
 * @author: TangLiang
 * @date: 2020/12/3 14:57
 * @since: 1.0
 */
public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;
        Question question = (Question) arg;
        System.out.println("====================");
        System.out.println(name + "老师，你好！ \n您收到了一个来自" + gPer.getName()
                + "的提问，希望您解答。内容问题如下: \n" + question.getConteng() +
                "\n提问者： " + question.getUserName());
    }
}
