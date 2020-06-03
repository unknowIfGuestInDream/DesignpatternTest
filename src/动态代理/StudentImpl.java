package 动态代理;

/**
 * @author: TangLiang
 * @date: 2020/6/3 10:01
 * @since: 1.0
 */
public class StudentImpl implements StudentDao {
    public void add() {
        System.out.println("添加学生");
    }

    public void update() {
        System.out.println("修改学生");
    }

    public void delete() {
        System.out.println("删除学生");
    }

    public void selete() {
        System.out.println("查询学生");
    }
}
