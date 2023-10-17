package algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(Integer val) {
        if (val != null) {
            this.val = val;
        }
    }

    TreeNode(List<Integer> list) {
        if (list == null || list.isEmpty()) return;
        TreeNode treeNode = constructTreeRecursive(list, 0);
        this.val = treeNode.val;
        this.left = treeNode.left;
        this.right = treeNode.right;
    }

    private TreeNode constructTreeRecursive(List<Integer> list, int index) {
        if (index >= list.size()) {
            return null;
        }
        if (list.get(index) == null) {
            return null;
        }
        TreeNode root = new TreeNode(list.get(index));
        root.left = constructTreeRecursive(list, 2 * index + 1);
        root.right = constructTreeRecursive(list, 2 * index + 2);
        return root;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void print() {
        printTreeRecursive(this, 0);
    }

    private void printTreeRecursive(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        printTreeRecursive(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.val);

        printTreeRecursive(node.left, level + 1);
    }
}
