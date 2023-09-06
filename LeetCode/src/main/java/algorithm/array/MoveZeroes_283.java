package algorithm.array;

public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroes_283().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
