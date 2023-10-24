package algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromPrePost_889 {
    public static void main(String[] args) {
        TreeNode treeNode = new ConstructFromPrePost_889().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        treeNode.print();
    }
    Map<Integer, Integer> index = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            index.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int leftVal = preorder[preStart + 1];
        int i = index.get(leftVal);

        int leftSize = i + 1 - postStart;
        TreeNode treeNode = new TreeNode(rootVal);

        treeNode.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, i);
        treeNode.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, i + 1, postEnd);
        return treeNode;
    }
}
