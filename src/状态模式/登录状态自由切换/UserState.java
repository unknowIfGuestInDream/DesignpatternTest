package 状态模式.登录状态自由切换;

/**
 * 抽象状态角色类
 *
 * @author: TangLiang
 * @date: 2021/2/1 15:31
 * @since: 1.0
 */
public abstract class UserState {
    protected AppContext context;

    public void setContext(AppContext context) {
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);
}
