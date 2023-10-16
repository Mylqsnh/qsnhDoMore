package algorithm.binaryTree;

import java.util.Arrays;

public class MaxDepth_104 {

    public static void main(String[] args) {
        int i = new MaxDepth_104().maxDepth(new TreeNode(Arrays.asList(3, 9, 20, 30, null, 15, 7, 40)));
        System.out.println(i);
    }

    int result = 0;

    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        if (root.left == null && root.right == null) {
            result = Math.max(depth, result);
        }

        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
