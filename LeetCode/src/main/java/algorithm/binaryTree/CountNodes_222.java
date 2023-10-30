package algorithm.binaryTree;

import java.util.Arrays;

public class CountNodes_222 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(Arrays.asList(1, 2, 3, 4, 5, 6));
        int i = new CountNodes_222().countNodes(treeNode);
        System.out.println(i);
    }

    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;

        while (l != null) {
            l = l.left;
            hl++;
        }

        while (r != null) {
            r = r.right;
            hr++;
        }

        if (hr == hl) {
            return (int)Math.pow(2, hl) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
