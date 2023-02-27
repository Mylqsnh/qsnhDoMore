package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1, 23, 49, 10};
        System.out.println(Arrays.toString(twoSum(nums, 50)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerIntegerHashMap.containsKey(target - nums[i])) {
                return new int[]{integerIntegerHashMap.get(target - nums[i]), i};
            }
            integerIntegerHashMap.put(nums[i], i);
        }

        return null;
    }
}
