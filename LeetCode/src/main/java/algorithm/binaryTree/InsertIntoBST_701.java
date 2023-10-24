package algorithm.binaryTree;

import java.util.Arrays;

public class InsertIntoBST_701 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(4, 2, 7, 1, 3));
        TreeNode treeNode1 = new InsertIntoBST_701().insertIntoBST(treeNode, 5);
        treeNode1.print();
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
