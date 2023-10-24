package algorithm.binaryTree;

import java.util.Arrays;

public class SearchBST_700 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(4, 2, 7, 1, 3));
        TreeNode treeNode1 = new SearchBST_700().searchBST(treeNode, 2);
        treeNode1.print();
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }
}
