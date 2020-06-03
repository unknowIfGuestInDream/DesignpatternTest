package 抽象工厂;

/**
 * @author: TangLiang
 * @date: 2020/6/3 11:32
 * @since: 1.0
 */
public interface ScrumFactory {
    Scrum createScrum();

    Chart createChart();
}
