package 策略模式.Demo;

/**
 * @author: TangLiang
 * @date: 2020/6/3 16:02
 * @since: 1.0
 */
public class Clint {
    public static void main(String[] args) {
        ICalculator calculator = new Add();
        Context context = new Context(calculator);
        int result = context.calc(1, 2);
        System.out.println(result);
    }

    interface ICalculator {
        int calc(int a, int b);
    }

    static class Add implements ICalculator {
        @Override
        public int calc(int a, int b) {
            return a + b;
        }
    }

    static class Sub implements ICalculator {
        @Override
        public int calc(int a, int b) {
            return a - b;
        }
    }

    static class Multi implements ICalculator {
        @Override
        public int calc(int a, int b) {
            return a * b;
        }
    }

    static class Divide implements ICalculator {
        @Override
        public int calc(int a, int b) {
            return a / b;
        }
    }

    static class Context {
        private ICalculator mCalculator;

        public Context(ICalculator calculator) {
            this.mCalculator = calculator;
        }

        public int calc(int a, int b) {
            return this.mCalculator.calc(a, b);
        }
    }
}
