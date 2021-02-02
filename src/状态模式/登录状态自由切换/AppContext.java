package 状态模式.登录状态自由切换;

/**
 * 上下文角色
 *
 * @author: TangLiang
 * @date: 2021/2/1 15:32
 * @since: 1.0
 */
public class AppContext {
    public static final UserState STATE_LOGIN = new LoginInState();
    public static final UserState STATE_UNLOGIN = new UnLoginInState();
    private UserState currentState = STATE_UNLOGIN;

    {
        STATE_LOGIN.setContext(this);
        STATE_UNLOGIN.setContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public UserState getState() {
        return this.currentState;
    }

    public void favorite() {
        this.currentState.favorite();
    }

    public void comment(String comment) {
        this.currentState.comment(comment);
    }
}
