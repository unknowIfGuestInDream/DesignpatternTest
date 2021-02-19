package 备忘录模式.demo1;

/**
 * 创建并在 Memento 对象中存储状态
 * @author: TangLiang
 * @date: 2021/2/19 10:19
 * @since: 1.0
 */
public class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}
