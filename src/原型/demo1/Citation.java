package 原型.demo1;

/**
 * @author: TangLiang
 * @date: 2021/2/3 19:04
 * @since: 1.0
 */
public class Citation implements Cloneable {
    private String name;
    private String info;
    private String college;

    public Object clone() {
        Citation w = null;
        try {
            w = (Citation) super.clone();
            System.out.println("拷贝成功！");
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝失败!");
        }
        return w;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Citation{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", college='" + college + '\'' +
                '}';
    }
}
