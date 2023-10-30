package algorithm.binaryTree.LCA;

import algorithm.binaryTree.TreeNode;

import java.util.Arrays;

public class LowestCommonAncestor_1644 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        treeNode.print();
        System.out.println();
        TreeNode result = new LowestCommonAncestor_1644().lowestCommonAncestor(treeNode,
                new TreeNode(6),
                new TreeNode(100));
        System.out.println(result);
        if (result != null) result.print();

    }

    boolean presentFirst = false;
    boolean presentSecond = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode treeNode = find(root, p, q);
        if (presentFirst && presentSecond) {
            return treeNode;
        }
        return null;
    }

    TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val) presentFirst = true;
            if (root.val == q.val) presentSecond = true;
            return root;
        }

        return left != null ? left : right;
    }
}
