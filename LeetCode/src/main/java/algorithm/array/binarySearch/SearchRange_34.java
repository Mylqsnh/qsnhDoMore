package algorithm.array.binarySearch;

public class SearchRange_34 {
    public static void main(String[] args) {
        int[] nums2 = {1, 2, 2, 2, 3, 4};
        int[] ints1 = new SearchRange_34().searchRange(nums2, 2);
        for (int i : ints1) {
            System.out.println(i);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target, true);
        int right = search(nums, target, false);

        if (left != -1 && right != -1) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    public int search(int[] nums, int target, boolean low) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (low) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        int ans = low ? left : right;
        if (ans < 0 || ans >= nums.length) {
            return -1;
        }
        return nums[ans] == target ? ans : -1;
    }
}
