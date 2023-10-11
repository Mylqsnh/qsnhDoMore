package algorithm.array;

import java.util.Arrays;

public class GetModifiedArray_370 {

    public static void main(String[] args) {
        int[] modifiedArray = new GetModifiedArray_370().getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
        System.out.println(Arrays.toString(modifiedArray));
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }

        return df.result();
    }

    class Difference {
        // 差分数组
        private int[] diff;

        public Difference(int[] nums) {
            if (nums.length <= 0) throw new AssertionError();
            int length = nums.length;
            diff = new int[length];
            diff[0] = nums[0];
            for (int i = 1; i < length; i++) {
                diff[i] = diff[i] - diff[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
