package algorithm.binaryTree;

import java.util.Arrays;

public class Flatten_114 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(1, 2, 5, 3, 4, 6));
        new Flatten_114().flatten(treeNode);
        treeNode.print();

    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
