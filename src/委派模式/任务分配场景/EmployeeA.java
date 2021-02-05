package 委派模式.任务分配场景;

/**
 * @author: TangLiang
 * @date: 2021/2/5 13:29
 * @since: 1.0
 */
public class EmployeeA implements IEmployee {
    protected String goodAt = "编程";

    @Override
    public void doing(String task) {
        System.out.println("我是员工A,我擅长" + goodAt + ",现在开始做" + task + "工作");
    }
}
