package 算法.linked;

/**
 * 环形单向链表解决约瑟夫问题
 */
public class JosephMain {
    // n = 5 5个人 k = 1 从第k个人开始报数 m = 2 数几次
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();
        linkedList.show();
        linkedList.addNode(25);
        linkedList.show();

        while (!linkedList.isEmpty()) {
            linkedList.moveFirst(1);
            Node node = linkedList.countAndPop(2);
            System.out.println(node);
        }

    }

    /**
     * 单向环形链表
     */
    static class CircleSingleLinkedList {
        Node first;

        public CircleSingleLinkedList() {
            first = new Node(1);
            first.next = first;
        }

        public void addNode(int number) {
            Node help = first;
            for (int i = 2; i <= number; i++) {
                help.next = new Node(i);
                help.next.next = first;
                help = help.next;
            }
        }

        public void show() {
            Node help = first;
            if (help != null) {
                System.out.println(help);
            } else {
                System.out.println("help is empty");
                return;
            }
            while (help.next != first) {
                help = help.next;
                System.out.println(help);
            }
            System.out.println("----------------------------");
        }

        public void moveFirst(int number) {
            for (int i = 0; i < number - 1; i++) {
                first = first.next;
            }
        }

        public Node countAndPop(int number) {
            if (isEmpty()) {
                System.out.println("pop is over!");
                return null;
            }
            Node res;
            if (first.next == first) {
                res = first;
                first = null;
                return res;
            }
            for (int i = 0; i < number - 1; i++) {
                first = first.next;
            }
            res = first;

            // help 指向 first的前一个节点
            Node help = first;
            while (help.next != first) {
                help = help.next;
            }

            // first往后移动一个节点
            first = first.next;
            //移除help和first之间的节点
            help.next = first;
            return res;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }

    static class Node {
        int id;
        Node next;

        public Node(int id) {
            this.id = id;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    '}';
        }
    }
}
