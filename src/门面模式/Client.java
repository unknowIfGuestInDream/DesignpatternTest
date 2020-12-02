package 门面模式;

/**
 * @author: TangLiang
 * @date: 2020/12/2 9:13
 * @since: 1.0
 */
public class Client {

    //客户
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }

    //子系统A
    static class SubSystemA {
        public void doA() {
            System.out.println("doing A stuff");
        }
    }

    //子系统B
    static class SubSystemB {
        public void doB() {
            System.out.println("doing B stuff");
        }
    }

    //子系统C
    static class SubSystemC {
        public void doC() {
            System.out.println("doing C stuff");
        }
    }

    //外观角色
    static class Facade {
        private SubSystemA a = new SubSystemA();
        private SubSystemB b = new SubSystemB();
        private SubSystemC c = new SubSystemC();

        //对外接口
        public void doA() {
            this.a.doA();
        }

        public void doB() {
            this.b.doB();
        }

        public void doC() {
            this.c.doC();
        }
    }

}
