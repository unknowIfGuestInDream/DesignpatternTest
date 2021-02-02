package 状态模式.登录状态自由切换;

/**
 * 未登录状态
 *
 * @author: TangLiang
 * @date: 2021/2/1 15:38
 * @since: 1.0
 */
public class UnLoginInState extends UserState {
    @Override
    public void favorite() {
        this.switch2Login();
        this.context.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.switch2Login();
        this.context.getState().comment(comment);
    }

    private void switch2Login() {
        System.out.println("跳转到登录页面");
        this.context.setState(this.context.STATE_LOGIN);
    }
}
