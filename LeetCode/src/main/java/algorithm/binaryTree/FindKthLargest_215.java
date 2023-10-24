package algorithm.binaryTree;

public class FindKthLargest_215 {

    public static void main(String[] args) {
        int[] a = new int[]{3,2,3,1,2,4,5,5,6};
        int kthLargest = new FindKthLargest_215().findKthLargest(a, 4);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {

        int l = 0;
        int r = nums.length - 1;
        int target = nums.length - k;

        while (l <= r) {
            int pivot = getPivot(nums, l, r);
            if (pivot == target) {
                return nums[pivot];
            } else if (pivot < target) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }

        return -1;
    }

    int getPivot(int[] nums, int low, int high) {
        int l = low;
        int r = high;
        int pivot = nums[low];

        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }

            while (l < r && nums[l] <= pivot) {
                l++;
            }

            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        nums[low] = nums[l];
        nums[l] = pivot;

        return l;
    }
}
