package 算法.linked;

import java.util.Stack;

/**
 * 单链表的增删改查
 */
public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(1, "赵1");
        Node node2 = new Node(2, "王2");
        Node node3 = new Node(3, "张3");
        Node node4 = new Node(4, "李4");

        Node node5 = new Node(4, "李4er~");
        Node node6 = new Node(5, "李4er111~");

        linkedList.size();
        linkedList.show();
        linkedList.addOrder(node2);
        linkedList.addOrder(node3);
        linkedList.addOrder(node1);
        linkedList.addOrder(node4);
        System.out.println("添加4个节点");
        linkedList.size();
        linkedList.show();
        linkedList.showDesc();

        linkedList.delete(1);
        linkedList.delete(2);
        System.out.println("删除2个节点");
        linkedList.size();
        linkedList.show();

        System.out.println("修改id4为李4er~");
        linkedList.update(node5);
        linkedList.size();
        linkedList.show();
        linkedList.showDesc();
        System.out.println("修改id5为李4er111~");
        linkedList.update(node6);
        linkedList.size();
        linkedList.show();
        linkedList.showDesc();
        System.out.println();
//        linkedList.getLastNode(1);
//        linkedList.getLastNode(2);
//        linkedList.getLastNode(3);
//        linkedList.getLastNode(4);
//        linkedList.getLastNode(5);
        System.out.println("翻转");
        linkedList.reversal();
        linkedList.show();

        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(new Node(1, "2"));
        linkedList1.add(new Node(3, "2"));
        linkedList1.add(new Node(5, "2"));
        linkedList1.add(new Node(10, "2"));
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(new Node(2, "2"));
        linkedList2.add(new Node(4, "2"));
        linkedList2.add(new Node(8, "2"));
        linkedList2.add(new Node(9, "2"));
        LinkedList list = merge(linkedList1, linkedList2);
        list.show();
    }

    public static Node generateEmptyNode() {
        return new Node();
    }

    private static LinkedList merge(LinkedList linkedList1, LinkedList linkedList2) {
        Node node1 = linkedList1.head.next;
        Node node2 = linkedList2.head.next;

        Node tempNode = generateEmptyNode();
        Node cur = tempNode;
        while (node1 != null && node2 != null) {
            if (node1.id == node2.id) {
                System.out.println("exist same node ,can not merge");
                return null;
            }
            if (node1.id < node2.id) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
//        cur.next = null;
        return new LinkedList(tempNode);
    }

    public static class LinkedList {
        Node head;

        public LinkedList() {
            this.head = generateEmptyNode();
        }

        public LinkedList(Node node) {
            this.head = node;
        }

        public void delete(int id) {
            if (isEmpty()) {
                return;
            }
            Node cur = head;
            while (cur.next.id != id) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        //逆序打印,使用栈
        public void showDesc() {
            Stack<Node> stack = new Stack<>();
            Node cur = head.next;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }
        }

        //反转
        public void reversal() {
            Node temp = generateEmptyNode();
            Node cur = head.next;
            while (cur != null) {
                Node next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                cur = next;
            }
            head = temp;
        }

        /**
         * 获取倒数第{index}个节点node
         *
         * @param index
         * @return
         */
        public Node getLastNode(int index) {
            Node cur = head.next;
            for (int i = 0; i < size() - index; i++) {
                cur = cur.next;
            }
            System.out.println(cur);
            return cur;
        }

        /**
         * 修改node
         *
         * @param node
         */
        public void update(Node node) {
            if (isEmpty()) {
                System.out.println("DoubleLinkedList is empty!");
                return;
            }
            Node cur = head.next;
            while (cur != null) {
                if (cur.id == node.id) {
                    cur.name = node.name;
                    return;
                }
                cur = cur.next;
            }
            System.out.println("nodeId: " + node.id + " is not exists");
        }

        public void addOrder(Node node) {
            if (isEmpty()) {
                head.next = node;
                return;
            }

            Node cur = head;
            while (true) {
                if (cur.next == null || node.id < cur.next.id) {
                    node.next = cur.next;
                    cur.next = node;
                    break;
                } else if (node.id == cur.next.id) {
                    System.out.println("exists same id,can no add!!");
                    break;
                } else {
                    cur = cur.next;
                }
            }
        }

        public void add(Node node) {
            if (isEmpty()) {
                head.next = node;
                return;
            }
            Node cur = head.next;
            while (true) {
                if (cur.next == null) {
                    break;
                }
                cur = cur.next;
            }
            cur.next = node;
        }

        public void show() {
            System.out.println("--------------------------");
            if (isEmpty()) {
                System.out.println("DoubleLinkedList is empty!");
                return;
            }

            Node cur = head.next;
            while (cur != null) {
                System.out.println(cur);
                cur = cur.next;
            }
        }

        public boolean isEmpty() {
            return head.next == null;
        }

        public int size() {
            int count = 0;
            Node cur = head.next;
            while (cur != null) {
                cur = cur.next;
                count++;
            }
            System.out.println("linked size is :" + count);
            return count;
        }

        public Node pop() {
            if (isEmpty()) {
                return null;
            }
            Node help = head;
            while (help.next.next != null) {
                help = help.next;
            }
            Node res = help.next;
            help.next = null;
            return res;
        }
    }

    public static class Node {
        public int id;
        public String name;
        public Node next;

        public Node() {
        }

        public Node(int id, String name) {
            this.id = id;
            this.name = name;
            this.next = null;
        }

        public Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
