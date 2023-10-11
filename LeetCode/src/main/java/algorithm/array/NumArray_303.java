package algorithm.array;

public class NumArray_303 {

    public static void main(String[] args) {
        NumArray_303 numArray = new NumArray_303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    private int[] preSum;

    public NumArray_303(int[] nums) {
        int length = nums.length;
        preSum = new int[length + 1];

        for (int i = 1; i < length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
