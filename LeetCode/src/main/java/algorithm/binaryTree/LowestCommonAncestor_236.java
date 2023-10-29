package algorithm.binaryTree;

import java.util.Arrays;

public class LowestCommonAncestor_236 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        TreeNode result = new LowestCommonAncestor_236().lowestCommonAncestor(treeNode, new TreeNode(6), new TreeNode(4));
        result.print();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
