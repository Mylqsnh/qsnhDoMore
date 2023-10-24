package algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree_106 {
    public static void main(String[] args) {
        TreeNode treeNode = new BuildTree_106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        treeNode.print();
    }

    Map<Integer, Integer> index = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) return null;

        int rootVal = postorder[postEnd];
        Integer i = index.get(rootVal);

        TreeNode treeNode = new TreeNode(rootVal);
        int leftSize = i - inStart;

        treeNode.left = build(inorder, inStart, i - 1,
                postorder, postStart, postStart + leftSize - 1);
        treeNode.right = build(inorder, i + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return treeNode;
    }
}
