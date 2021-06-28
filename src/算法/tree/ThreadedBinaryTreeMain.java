package 算法.tree;

/**
 * 线索化的二叉树
 */
public class ThreadedBinaryTreeMain {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node10 = new Node(10);
        Node node14 = new Node(14);
        Node root = node1;
        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
        root.left = node3;
        root.right = node6;
        node3.left = node8;
        node3.right = node10;
        node6.left = node14;
        //      1
        //  3       6
        //8  10   14
        //前序遍历线索化验证
        System.out.println("----------------");
//        tree.preThreadedNode(root);// 1-3-8-10-6-14
        //中序遍历线索化验证
//        tree.infixThreadedNode(root);//8-3-10-1-14-6
        //后续遍历线索化验证
        tree.postThreadedNode(root);// 8-10-3-14-6-1
//        System.out.println(node8.left);
//        System.out.println(node8.right);
//        System.out.println(node10.left);
//        System.out.println(node10.right);
//        System.out.println(node14.left);
//        System.out.println(node14.right);
//        System.out.println(node6.right);
        System.out.println("----------------");
//        tree.preThreadedOrder(root);
//        tree.infixThreadedOrder(root);
        tree.postThreadedOrder(root);
    }

    static class ThreadedBinaryTree {

        Node root;
        Node pre;

        //      1
        //  3       6
        //8  10   14
        //按照线索化遍历
        public void preThreadedOrder(Node node) {
            while (node != null) {
                System.out.println(" " + node + " ");
                //找到线索化二叉树的头,从root开始，头的左边一定是空的,且类型是0
                while (node.leftType == 0) {
                    node = node.left;
                    System.out.println(node);
                }
                while (node.rightType == 1) {
                    node = node.right;
                    System.out.println(node);
                }
                node = node.right;
            }
        }

        //按照线索化遍历
        // 8-3-10-1-14-6
        //      1
        //  3       6
        //8  10   14
        public void infixThreadedOrder(Node node) {
            while (node != null) {
                //找到线索化二叉树的头,从root开始，头的左边一定是空的,且类型是0
                while (node.leftType == 0) {
                    node = node.left;
                }
                System.out.println(" " + node + " ");
                while (node.rightType == 1) {
                    node = node.right;
                    System.out.println(node);
                }
                node = node.right;
            }
        }

        //按照线索化遍历 不使用递归太复杂，Node需要保存父节点
        // 8-10-3-14-6-1
        //      1
        //  3       6
        //8  10   14
        public void postThreadedOrder(Node node) {
            //使用递归遍历
            node.postThreadedOrder();
        }

        //      1
        //  3       6
        //8  10   14
        //前序线索化
        public void preThreadedNode(Node node) {
            if (node == null) {
                return;
            }

            if (node.left == null) {//如果左子节点不存在
                node.left = pre;
                node.leftType = 1;
            }

            //处理上一个节点 pre的 后继节点
            //如果是第一次操作,pre节点是空的,避免空指针
            if (pre != null && pre.right == null) {
                pre.right = node;
                pre.rightType = 1;
            }
            pre = node;

            //线索化左子节点
            if (node.leftType == 0) {
                preThreadedNode(node.left);
            }
            if (node.rightType == 0) {//如果最后一个节点的时候,必须判断,否则报错
                //线索化右子节点
                preThreadedNode(node.right);
            }
        }

        //      1
        //  3       6
        //8  10   14
        //中序线索化
        public void infixThreadedNode(Node node) {
            if (node == null) {
                return;
            }
            //线索化左子节点
            infixThreadedNode(node.left);

            if (node.left == null) {//如果左子节点不存在
                node.left = pre;
                node.leftType = 1;
            }

            //处理上一个节点 pre的 后继节点
            //如果是第一次操作,pre节点是空的,避免空指针
            if (pre != null && pre.right == null) {
                pre.right = node;
                pre.rightType = 1;
            }
            pre = node;

            //线索化右子节点
            infixThreadedNode(node.right);
        }

        //      1
        //  3       6
        //8  10   14
        //后序线索化
        public void postThreadedNode(Node node) {
            if (node == null) {
                return;
            }
            //线索化左子节点
            postThreadedNode(node.left);
            //线索化右子节点
            postThreadedNode(node.right);

            if (node.left == null) {//如果左子节点不存在
                node.left = pre;
                node.leftType = 1;
            }

            //处理上一个节点 pre的 后继节点
            //如果是第一次操作,pre节点是空的,避免空指针
            if (pre != null && pre.right == null) {
                pre.right = node;
                pre.rightType = 1;
            }
            pre = node;
        }

        public ThreadedBinaryTree(Node root) {
            this.root = root;
        }
    }

    static class Node {
        public int id;
        public Node left;
        public Node right;
        //0-普通左节点 1-线索化的节点
        public int leftType;
        //0-普通右节点 1-线索化的节点
        public int rightType;

        public Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    '}';
        }

        //线索化后续遍历
        public void postThreadedOrder() {
            if (left != null && leftType == 0) {
                left.postThreadedOrder();
            }
            if (right != null && rightType == 0) {
                right.postThreadedOrder();
            }
            System.out.println(" " + id + " ");
        }
    }
}
