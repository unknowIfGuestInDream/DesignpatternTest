package 状态模式.登录状态自由切换;

/**
 * 登录状态
 *
 * @author: TangLiang
 * @date: 2021/2/1 15:37
 * @since: 1.0
 */
public class LoginInState extends UserState {
    @Override
    public void favorite() {
        System.out.println("收藏成功");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
