package 备忘录模式.demo2;

/**
 * @author: TangLiang
 * @date: 2021/2/19 10:32
 * @since: 1.0
 */
public class PrototypeMemento {
    public static void main(String[] args) {
        OriginatorPrototype or = new OriginatorPrototype();
        PrototypeCaretaker cr = new PrototypeCaretaker();
        or.setState("S0");
        System.out.println("初始状态:" + or.getState());
        cr.setMemento(or.createMemento()); //保存状态
        or.setState("S1");
        System.out.println("新的状态:" + or.getState());
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:" + or.getState());
    }
}
//发起人原型
class OriginatorPrototype implements Cloneable {
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public OriginatorPrototype createMemento() {
        return this.clone();
    }
    public void restoreMemento(OriginatorPrototype opt) {
        this.setState(opt.getState());
    }
    public OriginatorPrototype clone() {
        try {
            return (OriginatorPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
//原型管理者
class PrototypeCaretaker {
    private OriginatorPrototype opt;
    public void setMemento(OriginatorPrototype opt) {
        this.opt = opt;
    }
    public OriginatorPrototype getMemento() {
        return opt;
    }
}
