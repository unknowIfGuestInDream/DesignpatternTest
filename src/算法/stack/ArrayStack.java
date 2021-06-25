package 算法.stack;

public class ArrayStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
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
        int maxSize;
        int[] arr;
        int point;

        public Stack(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
            point = -1;
        }

        public void push(int number) {
            if (isFull()) {
                System.out.println("stack is full");
                return;
            }
            arr[++point] = number;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return arr[point--];
        }

        public void show() {
            if (isEmpty()) {
                return;
            }
            int help = point;
            while (help >= 0) {
                System.out.printf("-%d-", arr[help--]);
            }
            System.out.println();
            System.out.println("---------------------------");
        }

        public boolean isFull() {
            return point == maxSize - 1;
        }

        public boolean isEmpty() {
            return point == -1;
        }
    }
}
