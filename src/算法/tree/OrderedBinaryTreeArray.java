package 算法.tree;

import java.util.Arrays;

/**
 * 数组实现顺序存储二叉树的前序,中序,后续遍历
 */
public class OrderedBinaryTreeArray {
    public static void main(String[] args) {
        OrderedBinaryTree tree = new OrderedBinaryTree(7);
        tree.showArr();
        /*
         *          [1]------0
         *         /    \
         *     [2]--1   [3]----2
         *    /  \       /  \
         * [4]-3 [5]-4 [6]-5[7]--6
         *
         * left   = 2*n+1
         * right  = 2*n+2
         * parent = (n-1)2
         *
         */
        tree.preTraversal();
        tree.infixTraversal();
        tree.postTraversal();
    }

    static class OrderedBinaryTree {
        int[] arr;

        public OrderedBinaryTree(int size) {
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i + 1;
            }
        }

        public void showArr() {
            System.out.println(Arrays.toString(arr));
        }

        public void preTraversal() {
            System.out.print("前序遍历:");
            preTraversal(0);
            System.out.println();
        }

        public void infixTraversal() {
            System.out.print("中序遍历:");
            infixTraversal(0);
            System.out.println();
        }

        public void postTraversal() {
            System.out.print("后序遍历:");
            postTraversal(0);
            System.out.println();
        }

        //前序遍历
        private void preTraversal(int index) {
            System.out.print(" " + arr[index] + " ");
            //遍历left
            int leftIndex = 2 * index + 1;
            if (leftIndex < arr.length) {
                preTraversal(leftIndex);
            }
            int rightIndex = 2 * index + 2;
            if (rightIndex < arr.length) {
                preTraversal(rightIndex);
            }
        }

        //中序遍历
        private void infixTraversal(int index) {
            //遍历left
            int leftIndex = 2 * index + 1;
            if (leftIndex < arr.length) {
                infixTraversal(leftIndex);
            }
            System.out.print(" " + arr[index] + " ");
            int rightIndex = 2 * index + 2;
            if (rightIndex < arr.length) {
                infixTraversal(rightIndex);
            }
        }

        //后序遍历
        private void postTraversal(int index) {
            //遍历left
            int leftIndex = 2 * index + 1;
            if (leftIndex < arr.length) {
                postTraversal(leftIndex);
            }
            int rightIndex = 2 * index + 2;
            if (rightIndex < arr.length) {
                postTraversal(rightIndex);
            }
            System.out.print(" " + arr[index] + " ");
        }
    }
}
