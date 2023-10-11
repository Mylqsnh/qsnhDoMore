package algorithm.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        int[] a = new int[]{1, -1, -1, 0};
        List<List<Integer>> lists = new ThreeSum_15().threeSum(a);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        return threeSumTarget(nums, 0);
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            List<List<Integer>> lists = twoSumTarget(nums, i + 1, target - temp);
            for (List<Integer> list : lists) {
                list.add(temp);
                result.add(list);
            }
            while (i < length - 1 && nums[i] == nums[i + 1]) i++;
        }

        return result;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        ArrayList<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int leftValue = nums[left];
            int rightValue = nums[right];
            if (sum == target) {
                result.add(new ArrayList<>(Arrays.asList(leftValue, rightValue)));
                while (left < right && nums[left] == leftValue) left++;
                while (left < right && nums[right] == rightValue) right--;
            } else if (sum > target) {
                while (left < right && nums[right] == rightValue) right--;
            } else if (sum < target) {
                while (left < right && nums[left] == leftValue) left++;
            }
        }

        return result;
    }
}
