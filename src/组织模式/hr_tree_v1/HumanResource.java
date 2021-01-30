package 组织模式.hr_tree_v1;

/**
 * @author: tangliang
 * @date: 2020/4/2 15:56.
 * @description: XXX
 */
public abstract class HumanResource {

    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
