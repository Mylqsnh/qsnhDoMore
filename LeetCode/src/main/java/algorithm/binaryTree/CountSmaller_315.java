package algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller_315 {
    public static void main(String[] args) {
        List<Integer> integers = new CountSmaller_315().countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(integers);
    }

    class Pair{
        int index, val;
        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    Pair[] temp;
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        temp = new Pair[length];
        count = new int[length];
        Pair[] arr = new Pair[length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        mergeSort(arr, 0, length - 1);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i : count) {
            result.add(i);
        }
        return result;
    }

    void mergeSort(Pair[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    void merge(Pair[] arr, int left, int mid, int right) {
        if (left >= right) {
            return;
        }

        int l = left, r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (arr[l].val > arr[r].val) {
                temp[index++] = arr[r++];
            } else {
                count[arr[l].index] += r - mid - 1;
                temp[index++] = arr[l++];
            }
        }

        while (l <= mid) {
            count[arr[l].index] += r - mid - 1;
            temp[index++] = arr[l++];
        }

        while (r <= right) {
            temp[index++] = arr[r++];
        }

        for (int i = 0; i < index; i++) {
            arr[left + i] = temp[i];
        }
    }
}
