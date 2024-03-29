package algorithm.array.nsum;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {

    public static void main(String[] args) {
        int[] nums = {1, 23, 49, 10};
        assert nums[0] == 0;
        assert nums[1] == 2;
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(nums, 50)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerIntegerHashMap.containsKey(target - nums[i])) {
                return new int[]{integerIntegerHashMap.get(target - nums[i]), i};
            }
            integerIntegerHashMap.put(nums[i], i);
        }

        return new int[0];
    }
}
