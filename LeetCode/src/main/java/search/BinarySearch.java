package search;

public class BinarySearch {

    public static void main(String[] args) {
        int [] nums = {-1,0,3,5,9,12};
        int search = search(nums, 9);
        assert search == 4;
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {

            int median = (l + r) / 2;

            if (nums[median] == target) {
                return median;
            }

            if (nums[median] < target) {
                l = median + 1;
            } else {
                r = median - 1;
            }
        }

        return -1;
    }
}
