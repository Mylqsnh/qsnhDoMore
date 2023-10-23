package algorithm.binaryTree;

import java.util.Arrays;

public class ConvertBST_538_1038 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
        TreeNode treeNode1 = new ConvertBST_538_1038().convertBST(treeNode);
        treeNode1.print();
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}