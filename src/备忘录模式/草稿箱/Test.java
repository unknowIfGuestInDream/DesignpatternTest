package 备忘录模式.草稿箱;

/**
 * @author: TangLiang
 * @date: 2021/2/22 10:27
 * @since: 1.0
 */
public class Test {
    public static void main(String[] args) {
        DraftsBox draftsBox = new DraftsBox();

        Editor editor = new Editor("每日日记", "今天是个好日子", "abc.jpg");

        ArticleMemento articleMemento = editor.saveToMemento();
        draftsBox.addMemento(articleMemento);

        System.out.println("标题:" + editor.getTitle() + "\n" +
                "内容:" + editor.getContent() + "\n" +
                "插图:" + editor.getImgs() + "\n 暂存成功");

        System.out.println("完整信息:" + editor);

        System.out.println("=====首次修改文章=====");
        editor.setTitle("每日日记");
        editor.setContent("今天是个好日子, 天气晴");
        System.out.println("完整信息:" + editor);
        System.out.println("=====首次修改完成=====");

        articleMemento = editor.saveToMemento();

        draftsBox.addMemento(articleMemento);

        System.out.println("=====保存到草稿箱=====");

        System.out.println("=====第2次修改文章=====");
        editor.setTitle("日记");
        editor.setContent("今天是个好日子, 天气晴, 阳光明媚");
        System.out.println("完整信息:" + editor);
        System.out.println("=====第2次修改完成=====");

        System.out.println("=====第1次撤销=====");
        articleMemento = draftsBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整信息:" + editor);
        System.out.println("=====第1次撤销完成=====");

        System.out.println("=====第2次撤销=====");
        articleMemento = draftsBox.getMemento();
        editor.undoFromMemento(articleMemento);
        System.out.println("完整信息:" + editor);
        System.out.println("=====第2次撤销完成=====");

    }
}
