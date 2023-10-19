package algorithm.binaryTree;

public class ReversePairs_493 {

    public static void main(String[] args) {
        int i = new ReversePairs_493().reversePairs(new int[]{2, 4, 3, 5, 1});
        System.out.println(i);
    }

    int count = 0;
    int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right) {
        if (left >= right) {
            return;
        }

        int end = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (end <= right && (long)nums[i] > (long)nums[end] * 2) {
                end++;
            }

            count += end - (mid + 1);
        }

        int l = left, r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (nums[l] > nums[r]) {
                temp[index++] = nums[r++];
            } else {
                temp[index++] = nums[l++];
            }
        }

        while (l <= mid) {
            temp[index++] = nums[l++];
        }

        while (r <= right) {
            temp[index++] = nums[r++];
        }

        for (int j = 0; j < index; j++) {
            nums[left + j] = temp[j];
        }
    }
}
