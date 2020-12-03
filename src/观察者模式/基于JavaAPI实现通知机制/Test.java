package 观察者模式.基于JavaAPI实现通知机制;

/**
 * @author: TangLiang
 * @date: 2020/12/3 15:02
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher jerry = new Teacher("Jerry");

        gPer.addObserver(tom);
        gPer.addObserver(jerry);

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setConteng("观察者模式应用哪些场景？");

        gPer.publishQuestion(question);
    }
}
