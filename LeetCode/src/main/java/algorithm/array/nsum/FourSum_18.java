package algorithm.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 0, -1, 0, -2, 2};

        List<List<Integer>> lists = new FourSum_18().fourSum(a, 0);

        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        return nSumTarget(nums, 4, 0, (long)target);
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start ,Long target) {

        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || sz < n) return res;
        if (n == 2) {
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(
                        nums,
                        n - 1,
                        i + 1,
                        target - nums[i]);
                for (List<Integer> arr : sub) {
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
