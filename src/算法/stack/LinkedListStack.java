package 算法.stack;

import 算法.linked.LinkedListMain;

public class LinkedListStack {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.show();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.show();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    static class Stack {
        LinkedListMain.LinkedList list;

        public Stack() {
            list = new LinkedListMain.LinkedList();
        }

        public void push(int number) {
            list.add(new LinkedListMain.Node(number));
        }

        public int pop() {
            LinkedListMain.Node node = list.pop();
            if (node == null) {
                throw new RuntimeException("stack is empty");
            }
            return node.id;
        }

        public void show() {
            list.show();
        }
    }

    static class Node {
        int id;
        int val;
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
