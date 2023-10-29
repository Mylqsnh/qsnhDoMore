package algorithm.binaryTree;

import java.util.Arrays;

public class LowestCommonAncestor_235 {

    public static void main(String[] args) {
        //BST
        TreeNode treeNode = new TreeNode(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));
        TreeNode result = new LowestCommonAncestor_235().lowestCommonAncestor(treeNode,
                new TreeNode(2),
                new TreeNode(8));

        result.print();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        return find(root, min, max);
    }

    TreeNode find(TreeNode root, int min, int max) {
        if (root == null) {
            return null;
        }

        if (root.val < min) {
            return find(root.right, min, max);
        }

        if (root.val > max) {
            return find(root.left, min, max);
        }

        return root;
    }
}
