package algorithm.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;

public class Serialize_297 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(1, 2, 3, null, null, 4, 5));
//        TreeNode treeNode = new TreeNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        treeNode.print();
        Serialize_297 serialize297 = new Serialize_297();
        String serialize = serialize297.serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = serialize297.deserialize(serialize);
        deserialize.print();

    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right,sb);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if (first.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
