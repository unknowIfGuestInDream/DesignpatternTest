package 委派模式.任务分配场景;

/**
 * @author: TangLiang
 * @date: 2021/2/5 13:31
 * @since: 1.0
 */
public class EmployeeB implements IEmployee {
    protected String goodAt = "平面设计";

    @Override
    public void doing(String task) {
        System.out.println("我是员工B,我擅长" + goodAt + ",现在开始做" + task + "工作");
    }
}
