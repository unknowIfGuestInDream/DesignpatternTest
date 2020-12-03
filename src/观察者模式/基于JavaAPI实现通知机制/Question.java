package 观察者模式.基于JavaAPI实现通知机制;

/**
 * 问题
 *
 * @author: TangLiang
 * @date: 2020/12/3 14:55
 * @since: 1.0
 */
public class Question {
    private String userName;
    private String conteng;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConteng() {
        return conteng;
    }

    public void setConteng(String conteng) {
        this.conteng = conteng;
    }
}
