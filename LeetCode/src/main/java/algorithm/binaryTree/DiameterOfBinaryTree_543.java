package algorithm.binaryTree;

import java.util.Arrays;

public class DiameterOfBinaryTree_543 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(1, 2));
        int i = new DiameterOfBinaryTree_543().diameterOfBinaryTree(treeNode);
        System.out.println(i);
    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        int diameter = left + right;
        maxDiameter = Math.max(maxDiameter, diameter);

        return 1 + Math.max(left, right);
    }
}
