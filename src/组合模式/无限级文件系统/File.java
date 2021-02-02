package 组合模式.无限级文件系统;

/**
 * @author: TangLiang
 * @date: 2021/2/2 14:23
 * @since: 1.0
 */
public class File extends Directory {
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
