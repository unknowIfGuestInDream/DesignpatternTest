package 简单工厂;

import java.util.List;
import java.util.Map;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:21
 * @since: 1.0
 */
public class Scrum1 implements Scrum {

    @Override
    public int addScrum() {
        return 1;
    }

    @Override
    public int updateScrum() {
        return 1;
    }

    @Override
    public void selectScrum() {
        System.out.println("我是Scrum1");
    }
}
