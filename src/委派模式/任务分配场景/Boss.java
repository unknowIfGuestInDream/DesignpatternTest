package 委派模式.任务分配场景;

/**
 * @author: TangLiang
 * @date: 2021/2/5 13:35
 * @since: 1.0
 */
public class Boss {
    public void commmand(String task, Leader leader) {
        leader.doing(task);
    }
}
