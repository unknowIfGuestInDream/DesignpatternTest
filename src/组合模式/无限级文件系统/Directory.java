package 组合模式.无限级文件系统;

/**
 * 顶层抽象组件
 *
 * @author: TangLiang
 * @date: 2021/2/2 14:22
 * @since: 1.0
 */
public abstract class Directory {
    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();
}
