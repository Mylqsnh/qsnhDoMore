package algorithm.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreorderTraversal_144 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(1, null, 2, null, null, 3));
        List<Integer> integers = new PreorderTraversal_144().preorderTraversal(treeNode);
        System.out.println(integers);
    }

    List<Integer> result;

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
