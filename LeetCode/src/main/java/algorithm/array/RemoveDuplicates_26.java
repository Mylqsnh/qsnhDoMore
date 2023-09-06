package algorithm.array;

public class RemoveDuplicates_26 {
    public static void main(String[] args) {
        int[] temp = {0, 0, 1, 1, 2, 2, 2 ,3, 3, 4};
        int i = new RemoveDuplicates_26().removeDuplicates(temp);
        assert i == 5;

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return ++slow;
    }
}
