package 策略模式.Demo;

/**
 * @author: TangLiang
 * @date: 2020/6/3 16:04
 * @since: 1.0
 */
public class EnumClient {
    public static void main(String[] args) {
        int result = Calculator.ADD.calc(1, 2);
        System.out.println(result);
        System.out.println(Calculator.ADD.getSymbol());
    }

    static enum Calculator {
        // 加法运算
        ADD("+") {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        },
        SUB("-") {
            @Override
            public int calc(int a, int b) {
                return a - b;
            }
        };
        private String symbol;

        private Calculator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public abstract int calc(int a, int b);
    }
}
