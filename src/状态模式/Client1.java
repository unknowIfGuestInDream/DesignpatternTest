package 状态模式;

/**
 * 因为不同的状态之间可能存在自动切换的场景（比如手机处于开机状态后悔激励切换到屏幕点亮状态）；
 * 但是Client未体现出场景切换功能，对Client进行修改，使其满足状态切换的功能
 *
 * @author: TangLiang
 * @date: 2021/2/1 13:56
 * @since: 1.0
 */
public class Client1 {

    //抽象状态类
    static abstract class State {
        protected Context context;

        public void setContext(Context context) {
            this.context = context;
        }

        public abstract void handle();
    }

    //具体状态类
    static class ConcreteStateA extends State {

        @Override
        public void handle() {
            System.out.println("StateA do action");
            //A状态完事后自动切换到B状态
            this.context.setState(Context.STATE_B);
            this.context.getState().handle();
        }
    }

    //具体状态类
    static class ConcreteStateB extends State {

        @Override
        public void handle() {
            System.out.println("StateB do action");
        }
    }

    //环境类
    static class Context {
        private static final State STATE_A = new ConcreteStateA();
        private static final State STATE_B = new ConcreteStateB();
        //默认状态A
        private State currentState = STATE_A;

        {
            STATE_A.setContext(this);
            STATE_B.setContext(this);
        }

        public void setState(State state) {
            this.currentState = state;
            this.currentState.setContext(this);
        }

        public State getState() {
            return this.currentState;
        }

        public void handle() {
            this.currentState.handle();
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateA());
        context.handle();
    }
}
