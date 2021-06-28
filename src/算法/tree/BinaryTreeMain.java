package 算法.tree;

/**
 * 二叉树的前序,中序,后序遍历
 */
public class BinaryTreeMain {
    static int times = 0;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        /*
                 1
               /   \
             2       3
              \     /  \
               6   4     5
                 /  \
               7     8
         */

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;
        BinaryTree binaryTree = new BinaryTree(node1);
        binaryTree.preOrder();   //1-2-3-4-5
//        binaryTree.deleteNodeDrict(4);
        binaryTree.deleteNodeAndMove(7);
        binaryTree.preOrder();   //1-2-3-4-5
        binaryTree.infixOrder(); //2-1-4-3-5
        binaryTree.postOrder();  //2-4-5-3-1

        int searchNum = 1;
        System.out.println("前序遍历查询到节点:" + binaryTree.preOrderSearch(searchNum) + ",共查了[" + times + "]次!");
        System.out.println("中序遍历查询到节点:" + binaryTree.infixOrderSearch(searchNum) + ",共查了[" + times + "]次!");
        System.out.println("后序遍历查询到节点:" + binaryTree.postOrderSearch(searchNum) + ",共查了[" + times + "]次!");

    }

    static class BinaryTree {
        public Node root;

        public BinaryTree(Node root) {
            this.root = root;
        }

        //前序遍历
        public void preOrder() {
            System.out.print("前序遍历:");
            if (root == null) {
                System.out.println("二叉树是空的...");
                return;
            }
            root.preOrder();
            System.out.println();
            System.out.println("--------------------");
        }

        //中序遍历
        public void infixOrder() {
            System.out.print("中序遍历:");
            if (root == null) {
                System.out.println("二叉树是空的...");
                return;
            }
            root.infixOrder();
            System.out.println();
            System.out.println("--------------------");
        }

        //后序遍历
        public void postOrder() {
            System.out.print("后序遍历:");
            if (root == null) {
                System.out.println("二叉树是空的...");
                return;
            }
            root.postOrder();
            System.out.println();
            System.out.println("--------------------");
        }

        //前序遍历查找
        public Node preOrderSearch(int no) {
            times = 0;
            System.out.print("前序遍历查找:");
            if (root == null) {
                System.out.println("二叉树是空的...");
                return null;
            }
            return root.preOrderSearch(no);
        }

        //中序遍历查找
        public Node infixOrderSearch(int no) {
            times = 0;
            System.out.print("中序遍历查找:");
            if (root == null) {
                System.out.println("二叉树是空的...");
                return null;
            }
            return root.infixOrderSearch(no);
        }

        //后序遍历查找
        public Node postOrderSearch(int no) {
            times = 0;
            System.out.print("后序遍历查找:");
            if (root == null) {
                System.out.println("二叉树是空的...");
                return null;
            }
            return root.postOrderSearch(no);
        }

        public void deleteNodeDrict(int no) {
            if (root == null) {
                return;
            }

            if (root.id == no) {
                root = null;
            } else {
                root.deleteNode(no);
            }
        }

               /*
                 1
               /   \
             2       3
              \     /  \
               6   4     5
                 /  \
               7     8
         */

        /**
         * 删除找到的节点
         * 1.如果节点没有子节点，直接删除
         * 2.如果节点有一个左节点或者只有一个右节点，则删除当前节点，且将字节点设置到当前位置
         * 3.如果左右子节点同事存在，则递归，让左节点上移，右字节点，按顺序下移，如果多出一个右下节点没有地方挂载，则挂载在最后一个字节点的左子节点
         *
         * @param no
         */
        public void deleteNodeAndMove(int no) {
            if (root == null) {
                return;
            }

            if (root.id == no) {
                //如果都为null
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left == null ^ root.right == null) {//如果只有一个为null
                    if (root.left != null) {
                        root = root.left;
                    }
                    if (root.right != null) {
                        root = root.right;
                    }
                                  /*
                 1
               /   \
             2       3
              \     /  \
               6   4     5
                 /  \
               7     8
         */

                } else {//两个都不为null
                    Node right = root.right;
                    root = root.left;
                    Node cur = root;
                    while (cur != null) {
                        Node temp = cur.right;
                        cur.right = right;
                        right = temp;
                        if (right != null && cur.left == null) {
                            cur.left = right;
                            cur = null;
                        } else {
                            cur = cur.left;
                        }
                    }
                }
            } else {
                root.deleteNodeAndMove(no);
            }
        }
    }

    static class Node {
        public int id;
        public Node left;
        public Node right;

        public Node(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    '}';
        }

        public void deleteNode(int no) {
            //如果当前节点的左节点存在且是目标节点 这设置为null即是删除节点
            if (this.left != null && this.left.id == no) {
                this.left = null;
                return;
            }

            if (this.right != null && this.right.id == no) {
                this.right = null;
                return;
            }
            //如果没找到且存在则向左递归继续删除
            if (this.left != null) {
                this.left.deleteNode(no);
            }
            if (this.right != null) {
                this.right.deleteNode(no);
            }
        }

        /*
             1
           /   \
         2       3
          \     /  \
           6   4     5
             /  \
           7     8
     */
        public void deleteNodeAndMove(int no) {
            //如果当前节点的左节点存在且是目标节点 这设置为null即是删除节点
            if (this.left != null && this.left.id == no) {
                //如果都为null
                if (this.left.left == null && this.left.right == null) {
                    this.left = null;
                } else if (this.left.left == null ^ this.left.right == null) {//如果只有一个为null
                    if (this.left.left != null) {
                        this.left = this.left.left;
                    }
                    if (this.left.right != null) {
                        this.left = this.left.right;
                    }
                } else {//两个都不为null
                    Node right = this.left.right;
                    this.left = this.left.left;
                    Node cur = this.left;
                    while (cur != null) {
                        Node temp = cur.right;
                        cur.right = right;
                        right = temp;
                        if (right != null && cur.left == null) {
                            cur.left = right;
                            cur = null;
                        } else {
                            cur = cur.left;
                        }
                    }
                }
                return;
            }

 /*
             1
           /   \
         2       3
          \     /  \
           6   4     5
             /  \
           7     8
*/
            //假设删除的no是3节点  this是1
            if (this.right != null && this.right.id == no) {
                //如果都为null
                if (this.right.left == null && this.right.right == null) {
                    this.right = null;
                } else if (this.right.left == null ^ this.right.right == null) {//如果只有一个为null
                    if (this.right.left != null) {
                        this.right = this.right.left;
                    }
                    if (this.right.right != null) {
                        this.right = this.right.right;
                    }
                } else {//两个都不为null
                    Node right = this.right.right;
                    this.right = this.right.left;
                    Node cur = this.right;
                    while (cur != null) {
                        Node temp = cur.right;
                        cur.right = right;
                        right = temp;
                        if (right != null && cur.left == null) {
                            cur.left = right;
                            cur = null;
                        } else {
                            cur = cur.left;
                        }
                    }
                }
                return;
            }
            //如果没找到且存在则向左递归继续删除
            if (this.left != null) {
                this.left.deleteNodeAndMove(no);
            }
            if (this.right != null) {
                this.right.deleteNodeAndMove(no);
            }
        }

        //前序遍历
        public void preOrder() {
            System.out.print(" " + id + " ");
            if (left != null) {
                left.preOrder();
            }
            if (right != null) {
                right.preOrder();
            }
        }

        //中序遍历
        public void infixOrder() {
            if (left != null) {
                left.infixOrder();
            }
            System.out.print(" " + id + " ");
            if (right != null) {
                right.infixOrder();
            }
        }

        //后序遍历查找
        public void postOrder() {
            if (left != null) {
                left.postOrder();
            }
            if (right != null) {
                right.postOrder();
            }
            System.out.print(" " + id + " ");
        }

        //前序遍历查找
        public Node preOrderSearch(int no) {
            times++;
            if (this.id == no) {
                return this;
            }
            Node res = null;
            if (this.left != null) {
                res = this.left.preOrderSearch(no);
            }

            if (res == null && this.right != null) {
                res = this.right.preOrderSearch(no);
            }
            return res;
        }

        //中序遍历查找
        public Node infixOrderSearch(int no) {
            Node res = null;
            if (this.left != null) {
                res = this.left.infixOrderSearch(no);
            }
            if (res != null) {
                return res;
            }
            times++;
            if (this.id == no) {
                return this;
            }

            if (this.right != null) {
                res = this.right.infixOrderSearch(no);
            }
            return res;
        }

        //后序遍历
        public Node postOrderSearch(int no) {
            Node res = null;
            if (this.left != null) {
                res = this.left.postOrderSearch(no);
            }
            if (res != null) {
                return res;
            }

            if (this.right != null) {
                res = this.right.postOrderSearch(no);
            }

            if (res != null) {
                return res;
            }

            times++;
            if (this.id == no) {
                return this;
            }
            return res;
        }
    }
}
