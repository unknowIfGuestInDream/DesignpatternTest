package 算法.queue;

/**
 * 数组实现环形队列
 */
public class CircleArrayQueueMain {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.show();
//        queue.add(4);
        System.out.println("弹出：" + queue.pop());
        System.out.println("弹出：" + queue.pop());
        queue.show();
        queue.add(4);
        queue.add(5);
        queue.show();
        System.out.println("弹出：" + queue.pop());
        System.out.println("弹出：" + queue.pop());
        System.out.println("弹出：" + queue.pop());
        queue.show();
        queue.add(6);
        queue.add(7);
        queue.add(8);
//        queue.add(9);
        queue.show();
    }

    static class ArrayQueue {
        int[] arr;
        int headIndex;
        int tailIndex;
        int maxSize;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize + 1;
            arr = new int[this.maxSize];
        }

        public boolean isEmpty() {
            return headIndex == tailIndex;
        }

        public boolean isFull() {
            return (headIndex + 1) % maxSize == tailIndex;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("集合是空的");
                throw new RuntimeException("集合是空的");
            }
            int res = arr[tailIndex];
            tailIndex = (tailIndex + 1) % maxSize;
            return res;
        }

        public void add(int item) {
            if (isFull()) {
                System.out.println("集合已经满了");
                throw new RuntimeException("集合已经满了");
            }
            arr[headIndex] = item;
            headIndex = (headIndex + 1) % maxSize;
        }

        public void show() {
            System.out.println("size:" + size());
            for (int i = tailIndex; i < tailIndex + size(); i++) {
                int tmp = i % maxSize;
                System.out.printf("--------------index[%d],value[%d]", tmp, arr[tmp]);
                System.out.println();
            }
            System.out.println("------------------------------");
        }

        private int size() {
            return (headIndex + maxSize - tailIndex) % maxSize;
        }
    }
}
