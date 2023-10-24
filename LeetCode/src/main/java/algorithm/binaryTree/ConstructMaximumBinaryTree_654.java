package algorithm.binaryTree;

public class ConstructMaximumBinaryTree_654 {
    public static void main(String[] args) {
        TreeNode treeNode = new ConstructMaximumBinaryTree_654().constructMaximumBinaryTree(new int[]{2, 3, 1, 6, 0, 5});
        treeNode.print();
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int index = -1, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode treeNode = new TreeNode(max);
        treeNode.left = build(nums, l, index - 1);
        treeNode.right = build(nums, index + 1, r);

        return treeNode;
    }
}
