package 中介者模式;

/**
 * @author: TangLiang
 * @date: 2020/12/3 15:13
 * @since: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleagueA colleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(mediator);
        colleagueA.depMethodA();
        System.out.println("----------------");
        colleagueB.depMethodB();
    }

    //抽象同事类
    static abstract class Colleague {
        protected Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }
    }

    //具体同事A
    static class ConcreteColleagueA extends Colleague {

        public ConcreteColleagueA(Mediator mediator) {
            super(mediator);
            this.mediator.setColleagueA(this);
        }

        //自发行为：Self-Method
        public void selfMethodA() {
            //处理自己逻辑
            System.out.println(this.getClass().getSimpleName() + ", self-Method");
        }

        //依赖方法:Dep-Method
        public void depMethodA() {
            //处理自己逻辑
            System.out.println(this.getClass().getSimpleName() + ":depMethod: delegate to Mediator");
            //无法处理的业务逻辑委托给中介者处理
            this.mediator.transferA();
        }

    }

    //具体同事B
    static class ConcreteColleagueB extends Colleague {

        public ConcreteColleagueB(Mediator mediator) {
            super(mediator);
            this.mediator.setColleagueB(this);
        }

        //自发行为：Self-Method
        public void selfMethodB() {
            //处理自己逻辑
            System.out.println(this.getClass().getSimpleName() + ", self-Method");
        }

        //依赖方法:Dep-Method
        public void depMethodB() {
            //处理自己逻辑
            System.out.println(this.getClass().getSimpleName() + ":depMethod: delegate to Mediator");
            //无法处理的业务逻辑委托给中介者处理
            this.mediator.transferB();
        }
    }

    //抽象中介者
    static abstract class Mediator {
        protected ConcreteColleagueA colleagueA;
        protected ConcreteColleagueB colleagueB;

        public void setColleagueA(ConcreteColleagueA colleagueA) {
            this.colleagueA = colleagueA;
        }

        public void setColleagueB(ConcreteColleagueB colleagueB) {
            this.colleagueB = colleagueB;
        }

        //中介者业务逻辑
        public abstract void transferA();

        public abstract void transferB();

    }

    //具体中介者
    static class ConcreteMediator extends Mediator {

        @Override
        public void transferA() {
            //协调行为 A转发到B
            this.colleagueB.selfMethodB();
        }

        @Override
        public void transferB() {
            //协调行为 B转发到A
            this.colleagueA.selfMethodA();
        }
    }

}
