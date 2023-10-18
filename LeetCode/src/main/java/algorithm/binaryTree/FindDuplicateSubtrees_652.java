package algorithm.binaryTree;

import java.util.*;

public class FindDuplicateSubtrees_652 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(1, 2, 3, 4, null, 2, 4, null, null, null, null, 4));
        treeNode.print();
        List<TreeNode> duplicateSubtrees = new FindDuplicateSubtrees_652().findDuplicateSubtrees(treeNode);
        for (TreeNode duplicateSubtree : duplicateSubtrees) {
            duplicateSubtree.print();
            System.out.println();
        }
    }
    List<TreeNode> result;
    Map<String, Integer> subTree = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result = new LinkedList<>();
        build(root);

        return result;
    }

    String build(TreeNode root) {
        if (root == null) return "#";

        String left = build(root.left);
        String right = build(root.right);

        String treeVal = left + "," + right + "," + root.val;
        Integer orDefault = subTree.getOrDefault(treeVal, 0);
        if (orDefault == 1) {
            result.add(root);
        }

        subTree.put(treeVal, orDefault + 1);

        return treeVal;
    }
}
