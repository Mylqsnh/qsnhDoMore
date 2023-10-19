package algorithm;

import java.util.Arrays;

public class SortArray_912 {
    public static void main(String[] args) {
        int[] ints = new SortArray_912().sortArray(new int[]{5, 2, 3, 1});
        System.out.println(Arrays.toString(ints));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }

        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    void mergeSort(int[] nums, int left, int right, int[] temp) {

        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        merge(nums, left, mid, right, temp);
    }

    void merge(int[] nums, int left, int mid, int right, int[] temp) {

        if (left >= right) {
            return;
        }

        int l = left;
        int r = mid + 1;
        int index = 0;

        while (l <= mid && r <= right) {
            if (nums[l] < nums[r]) {
                temp[index++] = nums[l++];
            } else {
                temp[index++] = nums[r++];
            }
        }

        while (l <= mid) {
            temp[index++] = nums[l++];
        }

        while (r <= right) {
            temp[index++] = nums[r++];
        }

        for (int i = 0; i < index; i++) {
            nums[left + i] = temp[i];
        }
    }
}
