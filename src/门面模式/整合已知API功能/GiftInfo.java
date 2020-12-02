package 门面模式.整合已知API功能;

/**
 * 礼品实体类
 *
 * @author: TangLiang
 * @date: 2020/12/2 9:22
 * @since: 1.0
 */
public class GiftInfo {
    private String name;

    public GiftInfo(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
