package algorithm.binaryTree;

import java.util.Arrays;

public class InvertTree_226 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(4, 7, 2, 9, 6, 3, 1));
        treeNode.print();
        TreeNode treeNode1 = new InvertTree_226().invertTree(treeNode);
        treeNode1.print();
    }

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }

}
