package 备忘录模式.demo1;

/**
 * 包含了要被恢复的对象的状态
 *
 * @author: TangLiang
 * @date: 2021/2/19 10:19
 * @since: 1.0
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
