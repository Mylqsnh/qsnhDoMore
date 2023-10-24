package algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_105 {

    public static void main(String[] args) {
        TreeNode treeNode = new BuildTree_105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        treeNode.print();
    }

    Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        Integer i = index.get(rootVal);

        TreeNode treeNode = new TreeNode(rootVal);
        int leftSize = i - inStart;

        treeNode.left = build(
                preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, i - 1);
        treeNode.right = build(
                preorder, preStart + leftSize + 1, preEnd,
                inorder, i + 1, inEnd);

        return treeNode;
    }
}
