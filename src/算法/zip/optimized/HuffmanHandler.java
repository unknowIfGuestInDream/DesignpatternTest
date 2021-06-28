package 算法.zip.optimized;

import java.util.*;

public class HuffmanHandler {
    Map<Byte, Integer> map;
    private static Map<Byte, String> huffmanCode = new HashMap<>();

    public HuffmanHandler() {

    }

    public HuffmanHandler(Map<Byte, Integer> map) {
        this.map = map;
    }

    public Map<Byte, String> generateHuffmanCode() {
        //根据统计的出现次数构建一个Huffman树
        Node root = generateHuffmanTreeNode(map);
        //根据Huffman树获取不重复的路径编码  左为0  右为1,即是编码表
        Map<Byte, String> huffmanCode = getHuffmanCode(root);
        return huffmanCode;
    }

    private static Node generateHuffmanTreeNode(Map<Byte, Integer> map) {
        List<Node> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getValue(), entry.getKey());
            list.add(node);
        }
        return buildHuffmanTree(list);
    }

    //构建一个哈夫曼树
    private static Node buildHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            //排序List
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(left.weight + right.weight, null);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static Map<Byte, String> getHuffmanCode(Node root) {
        //这里使用中序遍历遍历Huffman树
        if (root.left != null) {
            getCode(root.left, "0", "");
        }
        if (root.right != null) {
            getCode(root.right, "1", "");
        }
        return huffmanCode;
    }

    private static void getCode(Node node, String str, String source) {
        source += str;
        //如果是叶子节点
        if (node.val != null) {
            huffmanCode.put(node.val, source);
        }
        if (node.left != null) {
            getCode(node.left, "0", source);
        }

        if (node.right != null) {
            getCode(node.right, "1", source);
        }
    }
}
