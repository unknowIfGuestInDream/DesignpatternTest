package 算法.calcuate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式的运算
 */
public class SuffixExpression {
    public static void main(String[] args) {
        // (3+4)*5-6 = 29
//        String suffixExpression = "3 4 + 5 * 60 -";
        //10 2 3 + 4 * + 5 - =10+((2+3)*4)-5 = 25
        String suffixExpression = "10 2 3 + 4 * + 5 -";

        int res = calculateSuffix(parse(suffixExpression));
        System.out.println("计算结果是：" + res);
    }

    /**
     * 把表达式拆分到list中
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> parse(String suffixExpression) {
        List<String> res = new ArrayList();
        String[] split = suffixExpression.split(" ");
        for (String item : split) {
            res.add(item);
        }
        return res;
    }

    /**
     * 运算后缀表达式，遇到数字入栈，遇到符号弹出两个数运算
     *
     * @param suffixExpression
     * @return
     */
    public static int calculateSuffix(List<String> suffixExpression) {
        Stack<String> stack = new Stack<>();
        for (String item : suffixExpression) {
            if (isNumber(item)) {
                stack.push(item);
            } else if (isOperate(item)) {
                Integer number1 = Integer.parseInt(stack.pop());
                Integer number2 = Integer.parseInt(stack.pop());
                stack.push(operate(number1, number2, item.charAt(0)) + "");
            }
        }
        int res = Integer.parseInt(stack.pop());
        System.out.println("运算结果是：" + res);
        return res;
    }

    public static int operate(int number1, int number2, char popOper) {
        int res = 0;
        switch (popOper) {
            case '+':
                res = number2 + number1;
                break;
            case '-':
                res = number2 - number1;
                break;
            case '*':
                res = number2 * number1;
                break;
            case '/':
                res = number2 / number1;
                break;
            default:
                throw new ArithmeticException("can not discern operate exception");
        }
        return res;
    }

    public static boolean isOperate(String string) {
        if ("+".equals(string)
                || "-".equals(string) || "*".equals(string) || "/".equals(string)) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String string) {
        return string.matches("\\d+");
    }
}
