package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 1, 0, 9, 8, 6, 10, 20, 13};
        System.out.println("快排之前：");
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("\n快排之后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr:待排序的数组
     * @param low：左边低位指针
     * @param high：右边高位指针
     */
    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int l = low;
        int r = high;
        int temp = 0;
        int pivot = arr[low];

        while (l < r) {
            //先右遍历，需要判断arr[l=r] > arr[low]
            while (l < r && arr[r] >= pivot) {
                r--;
            }

            while (l < r && arr[l] <= pivot) {
                l++;
            }

            if (l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        arr[low] = arr[l];
        arr[l] = pivot;

        if (low < l) {
            quickSort(arr, low, l - 1);
        }

        if (high > r) {
            quickSort(arr, r + 1, high);
        }

    }
}
