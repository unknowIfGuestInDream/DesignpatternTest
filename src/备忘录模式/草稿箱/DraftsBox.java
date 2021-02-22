package 备忘录模式.草稿箱;

import java.util.Stack;

/**
 * 草稿箱
 *
 * @author: TangLiang
 * @date: 2021/2/22 10:25
 * @since: 1.0
 */
public class DraftsBox {

    private final Stack<ArticleMemento> STACK = new Stack<>();

    public ArticleMemento getMemento() {
        ArticleMemento articleMemento = STACK.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento) {
        STACK.push(articleMemento);
    }
}
