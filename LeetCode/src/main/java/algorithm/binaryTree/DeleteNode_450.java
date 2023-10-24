package algorithm.binaryTree;

import java.util.Arrays;

public class DeleteNode_450 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(5, 3, 6, 2, 4, null, 7));
        TreeNode treeNode1 = new DeleteNode_450().deleteNode(treeNode, 3);
        treeNode1.print();
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode min = getMin(root.right);

            root.right = deleteNode(root.right, min.val);

            min.left = root.left;
            min.right = root.right;
            root = min;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }


    TreeNode getMin(TreeNode treeNode) {
        while (treeNode.left != null) treeNode = treeNode.left;
        return treeNode;
    }
}
