package algorithm.binaryTree;

import java.util.Arrays;

public class IsValidBST_98 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(5, 1, 4, null, null, 3, 6));
        boolean validBST = new IsValidBST_98().isValidBST(treeNode);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root ,max);
    }
}
