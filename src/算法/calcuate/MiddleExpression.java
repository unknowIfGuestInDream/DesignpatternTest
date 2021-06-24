package 算法.calcuate;

import java.util.Stack;

/**
 * 中缀表达式 计算器
 */
public class MiddleExpression {
    public static void main(String[] args) {
        String expression = "2*14-2*3+12/6-3";
        System.out.println(expression + "=" + middle(expression));
    }

    private static int middle(String expression) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        String numberTemp = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isNumber(ch)) {
                //考虑多位数字情况
                numberTemp += ch;
                //下一个数存在且还是数字
                if (i + 1 < expression.length() && isNumber(expression.charAt(i + 1))) {
                    continue;
                }
                numberStack.push(Integer.parseInt(numberTemp));
                //切记清空
                numberTemp = "";
            } else if (isOper(ch)) {
                tryPushOper(numberStack, operStack, ch);
            } else {
                throw new RuntimeException("Unknown exception");
            }
        }

        while (!operStack.isEmpty()) {
            char popOper = operStack.pop();
            int number1 = numberStack.pop();
            int number2 = numberStack.pop();
            numberStack.push(oper(number2, number1, popOper));
        }
        return numberStack.peek();
    }

    public static void tryPushOper(Stack<Integer> numberStack, Stack<Character> operStack, char ch) {
        if (operStack.isEmpty()) {
            //入符号栈
            operStack.push(ch);
            return;
        }
        char oper = operStack.peek();
        //如果弹出的符号优先级高,或者相等，则先弹出进行运算
        if (!isPriorTo(ch, oper)) {
            //运算
            int number1 = numberStack.pop();
            int number2 = numberStack.pop();
            char popOper = operStack.pop();
            numberStack.push(oper(number2, number1, popOper));
            //再次尝试推入符号栈
            tryPushOper(numberStack, operStack, ch);
        } else {
            //入符号栈
            operStack.push(ch);
        }
    }

    private static int oper(int number1, int number2, char popOper) {
        int res = 0;
        switch (popOper) {
            case '+':
                res = number1 + number2;
                break;
            case '-':
                res = number1 - number2;
                break;
            case '*':
                res = number1 * number2;
                break;
            case '/':
                res = number1 / number2;
                break;
            default:
                throw new ArithmeticException("can not discern oper exception");
        }
        return res;
    }

    public static boolean isPriorTo(char ch1, char ch2) {
        int level1 = getLevel(ch1);
        int level2 = getLevel(ch2);
        return level1 > level2;
    }

    public static int getLevel(char ch) {
        int res = -1;
        switch (ch) {
            case '+':
                res = 1;
                break;
            case '-':
                res = 1;
                break;
            case '*':
                res = 2;
                break;
            case '/':
                res = 2;
                break;
            default:
                throw new ArithmeticException("can not discern oper exception");
        }
        return res;
    }

    public static boolean isOper(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
    }

    public static boolean isNumber(char ch) {
        if ("0123456789".indexOf(ch) != -1) {
            return true;
        }
        return false;
    }
}
