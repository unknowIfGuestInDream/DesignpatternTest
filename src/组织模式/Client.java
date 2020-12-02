package 组织模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: TangLiang
 * @date: 2020/12/2 13:57
 * @since: 1.0
 */
public class Client {

    public static void main(String[] args) {
        //创建一个根节点
        Component root = new Composite("root");
        //创建一个树枝节点
        Component branchA = new Composite("---branchA");
        Component branchB = new Composite("------branchB");
        //创建一个叶子节点
        Component leafA = new Leaf("------leafA");
        Component leafB = new Leaf("---------leafB");
        Component leafC = new Leaf("---leafC");

        root.addChild(branchA);
        root.addChild(leafC);
        branchA.addChild(leafA);
        branchA.addChild(branchB);
        branchB.addChild(leafB);

        String result = root.operation();
        System.out.println(result);
    }

    static abstract class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract String operation();

        public boolean addChild(Component component) {
            throw new UnsupportedOperationException("addChild not supported!");
        }

        public boolean removeChild(Component component) {
            throw new UnsupportedOperationException("removeChild not supported!");
        }

        public Component getChild(int index) {
            throw new UnsupportedOperationException("getChild not supported!");
        }
    }

    //树枝节点
    static class Composite extends Component {
        private List<Component> components;

        public Composite(String name) {
            super(name);
            this.components = new ArrayList<>();
        }

        @Override
        public String operation() {
            StringBuilder builder = new StringBuilder(this.name);
            for (Component component : components) {
                builder.append("\n");
                builder.append(component.operation());
            }
            return builder.toString();
        }

        public boolean addChild(Component component) {
            return components.add(component);
        }

        public boolean removeChild(Component component) {
            return components.remove(component);
        }

        public Component getChild(int index) {
            return components.get(index);
        }

    }

    //叶子节点
    static class Leaf extends Component {

        public Leaf(String name) {
            super(name);
        }

        @Override
        public String operation() {
            return this.name;
        }
    }

}
