package 算法.calcuate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 */
public class MiddleToSuffixExpression {

    //10+((2+3)*4)-5 ==> 10 2 3 + 4 * + 5 -

    public static void main(String[] args) {
        String expression = "10+((2+3)*4)-5";
        List<String> middleExpressionList = parse(expression.trim());
        List<String> suffixExpressionList = toSuffixExpression(middleExpressionList);
        SuffixExpression.calculateSuffix(suffixExpressionList);
    }

    /**
     * 中缀转后缀运算
     *
     * @param middleExpressionList
     * @return
     */
    private static List<String> toSuffixExpression(List<String> middleExpressionList) {
        List<String> suffixExpressionList = new ArrayList<>();

        Stack<String> stack = new Stack<>();
        for (String item : middleExpressionList) {
            //如果是数字，则存入list
            if (SuffixExpression.isNumber(item)) {
                suffixExpressionList.add(item);
            } else if ("(".equals(item)) {//如果是“(”入栈
                stack.push(item);
            } else if (")".equals(item)) {//如果是“)”，弹出所有符号入栈，直到“(”
                while (!"(".equals(stack.peek())) {
                    suffixExpressionList.add(stack.pop());
                }
                stack.pop();//弹出“(”,没啥用
            } else if (SuffixExpression.isOperate(item)) {//如果是运算符号，不包括括号
                //栈为空直接入栈
                if (stack.isEmpty()) {
                    stack.push(item);
                    continue;
                }
                //如果当前元素优先级大于栈顶元素，则入栈
                if ("(".equals(stack.peek()) || isPriorTo(item, stack.peek())) {
                    stack.push(item);
                } else {//如果当前元素优先级小于等于 栈顶元素，则弹出栈顶元素，直到当前元素大于栈顶元素，然后入栈
                    while (!stack.isEmpty() && !isPriorTo(item, stack.peek())) {
                        suffixExpressionList.add(stack.pop());
                    }
                    //入栈
                    stack.push(item);
                }
            } else {
                throw new RuntimeException("怎么啥都不是？");
            }
        }

        //弹出栈中的所有内容存入list
        while (!stack.isEmpty()) {
            suffixExpressionList.add(stack.pop());
        }

        System.out.print("后缀表达式：");
        suffixExpressionList.stream().forEach((x) -> System.out.print(" " + x + " "));
        System.out.println();
        return suffixExpressionList;
    }

    public static boolean isPriorTo(String string1, String string2) {
        int level1 = getLevel(string1);
        int level2 = getLevel(string2);
        return level1 > level2;
    }

    public static int getLevel(String string) {
        int res = -1;
        switch (string) {
            case "+":
                res = 1;
                break;
            case "-":
                res = 1;
                break;
            case "*":
                res = 2;
                break;
            case "/":
                res = 2;
                break;
            default:
                throw new ArithmeticException("can not discern oper exception");
        }
        return res;
    }

    //将表达式按照符号和数字分别存入List，考虑连续数字问题
    private static List<String> parse(String expression) {
        List<String> result = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            temp += ch;
            if (SuffixExpression.isNumber(ch + "") //当前元素是数字
                    && i + 1 < expression.length() //下一个元素存在
                    && SuffixExpression.isNumber(expression.charAt(i + 1) + "")) {//下一个元素也是数字
            } else {
                result.add(temp);
                temp = "";//关键
            }

        }
        System.out.print("中缀表达式：");
        result.stream().forEach((x) -> System.out.print(" " + x + " "));
        System.out.println();
        return result;
    }
}
