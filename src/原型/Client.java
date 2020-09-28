package 原型;

/**
 * @author: TangLiang
 * @date: 2020/9/27 9:35
 * @since: 1.0
 */
public class Client {

    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("originalA");
        System.out.println("prototypeA: " + prototypeA);
        ConcretePrototypeA cloneTypeA = prototypeA.clone();
        cloneTypeA.desc = "clone";
        System.out.println("cloneTypeA: " + cloneTypeA);

        ConcretePrototypeC prototypeB = new ConcretePrototypeC("originalB");
        ConcretePrototypeC cloneTypeB = prototypeB.clone();
        System.out.println("cloneTypeB: " + cloneTypeB);
    }

    interface IPrototype<T> {
        T clone();
    }

    static class ConcretePrototypeC implements Cloneable {

        private String desc;

        public ConcretePrototypeC(String desc) {
            this.desc = desc;
        }

        @Override
        public ConcretePrototypeC clone() {
            return new ConcretePrototypeC(this.desc);
        }

        @Override
        public String toString() {
            return "ConcretePrototypeC{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    static class ConcretePrototypeB implements IPrototype<ConcretePrototypeB> {

        private String desc;

        public ConcretePrototypeB(String desc) {
            this.desc = desc;
        }

        @Override
        public ConcretePrototypeB clone() {
            return new ConcretePrototypeB(this.desc);
        }

        @Override
        public String toString() {
            return "ConcretePrototypeB{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    static class ConcretePrototypeA implements IPrototype<ConcretePrototypeA> {

        private String desc;

        public ConcretePrototypeA(String desc) {
            this.desc = desc;
        }

        @Override
        public ConcretePrototypeA clone() {
            return new ConcretePrototypeA(this.desc);
        }

        @Override
        public String toString() {
            return "ConcretePrototypeA{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }
}
