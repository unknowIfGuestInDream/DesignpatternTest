package 状态模式.登录状态自由切换;

/**
 * @author: TangLiang
 * @date: 2021/2/1 15:41
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        AppContext context = new AppContext();
        context.favorite();
        context.comment("评论：好文章，点赞");
    }
}
