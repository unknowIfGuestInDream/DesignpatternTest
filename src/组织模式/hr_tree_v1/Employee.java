package 组织模式.hr_tree_v1;

/**
 * @author: tangliang
 * @date: 2020/4/2 15:58.
 * @description: XXX
 */
public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return this.salary;
    }
}
