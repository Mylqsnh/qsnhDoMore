package algorithm.binaryTree.LCA;

import algorithm.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestor_1676 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        treeNode.print();
        System.out.println();
        TreeNode treeNode1 = new LowestCommonAncestor_1676().lowestCommonAncestor(treeNode,
                new TreeNode[]{new TreeNode(7), new TreeNode(4), new TreeNode(6)});
        treeNode1.print();

    }

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        ArrayList<Integer> values = new ArrayList<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }

        return find(root, values);
    }

    TreeNode find(TreeNode root, List<Integer> valuse) {
        if (root == null) return null;

        if (valuse.contains(root.val)) {
            return root;
        }

        TreeNode left = find(root.left, valuse);
        TreeNode right = find(root.right, valuse);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}
