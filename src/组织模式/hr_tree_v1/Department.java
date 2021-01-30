package 组织模式.hr_tree_v1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tangliang
 * @date: 2020/4/2 15:58.
 * @description: XXX
 */
public class Department extends HumanResource {

    private List<HumanResource> subNodes = new ArrayList<>(16);

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        if (subNodes.size() == 0) {
            return 0;
        }
        double totalSalary = 0;
        for (HumanResource department : subNodes) {
            totalSalary += department.calculateSalary();
        }
        this.salary = totalSalary;
        return salary;
    }

    public void addNode(HumanResource node) {
        subNodes.add(node);
    }
}
