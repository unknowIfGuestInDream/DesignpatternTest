package 算法.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeMain {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};

        Node root = buildHuffmanTree(arr);
        root.preOrder();
    }

    private static Node buildHuffmanTree(int[] arr) {
        //将数组保存到ArrayList中,方便删除,新增
        List<Node> nodes = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }

        return buildHuffmanTree(nodes);

    }

    private static Node buildHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序List
            Collections.sort(nodes);

            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    static class Node implements Comparable<Node> {

        public int weight;
        public Node left;
        public Node right;

        public Node(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    '}';
        }

        public void preOrder() {
            System.out.print(" " + weight + " ");
            if (this.left != null) {
                this.left.preOrder();
            }
            if (this.right != null) {
                this.right.preOrder();
            }
        }
    }

}
