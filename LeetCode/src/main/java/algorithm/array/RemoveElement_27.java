package algorithm.array;

public class RemoveElement_27 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int i = new RemoveElement_27().removeElement(nums, 2);
        assert i == 6;

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
