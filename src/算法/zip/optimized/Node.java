package 算法.zip.optimized;

class Node implements Comparable<Node> {

    public int weight;
    public Byte val;
    public Node left;
    public Node right;

    public Node(int weight, Byte val) {
        this.weight = weight;
        this.val = val;
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
        System.out.print(" " + weight + "[" + val + "] ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}