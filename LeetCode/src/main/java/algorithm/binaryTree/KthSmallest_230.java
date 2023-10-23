package algorithm.binaryTree;

import java.util.Arrays;

public class KthSmallest_230 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(5, 3, 6, 2, 4, null, null, 1));
        int i = new KthSmallest_230().kthSmallest(treeNode, 3);
        System.out.println(i);
    }

    int result = 0;

    int temp = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) return;

        traverse(root.left, k);
        temp++;
        if (temp == k) {
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }
}