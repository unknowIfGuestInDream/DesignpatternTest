package 备忘录模式.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责从 Memento 中恢复对象的状态
 *
 * @author: TangLiang
 * @date: 2021/2/19 10:20
 * @since: 1.0
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
