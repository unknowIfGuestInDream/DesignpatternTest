package 组合模式.无限级文件系统;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TangLiang
 * @date: 2021/2/2 14:24
 * @since: 1.0
 */
public class Folder extends Directory {
    private List<Directory> dirs;
    private Integer level;

    public Folder(String name, Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<>();
    }

    @Override
    public void show() {
        System.out.println(this.name);
        for (Directory dir : this.dirs) {
            //控制显示格式
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    //打印空格控制样式
                    System.out.print(" ");
                }
                for (int i = 0; i < this.level; i++) {
                    //每一行开始打印一个+
                    if (i == 0) System.out.print("+");
                    System.out.print("-");
                }
            }
            dir.show();
        }
    }

    public boolean add(Directory dir) {
        return this.dirs.add(dir);
    }

    public boolean remove(Directory dir) {
        return this.dirs.remove(dir);
    }

    public Directory get(int index) {
        return this.dirs.get(index);
    }

    public void list() {
        for (Directory dir : this.dirs) {
            System.out.println(dir.name);
        }
    }

}
