package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 1, 0, 9, 8, 6, 10, 20, 13};
        System.out.println("before：");
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("\nafter：");
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int index = i;
            while (index - 1 >= 0 && current < arr[index - 1]) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = current;
        }
    }
}
