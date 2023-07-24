package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,1,0,9,8,6,10,20,13};
        System.out.println("before：");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("\nafter：");
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr,
                                  int left,
                                  int right,
                                  int[] temp) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr,
                              int left,
                              int mid,
                              int right,
                              int[] temp) {
        int l = left;
        int r = mid + 1;
        int index = 0;

        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                temp[index++] = arr[l++];
            } else {
                temp[index++] = arr[r++];
            }
        }

        while (l <= mid) {
            temp[index++] = arr[l++];
        }

        while (r <= right) {
            temp[index++] = arr[r++];
        }

        for (int j = 0; j < index; j++) {
            arr[left + j] = temp[j];
        }
    }

}
