package sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 1, 0, 9, 8, 6, 10, 20, 13};
        System.out.println("before：");
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("\nafter：");
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }

        for (int digit = 1; digit <= maxDigit; digit++) {
            int count[] = new int[10];
            int output[] = new int[arr.length];

            for (int i : arr) {
                int index = (i / (int) Math.pow(10, digit - 1)) % 10;
                count[index]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                int index = (arr[i] / (int) Math.pow(10, digit - 1)) % 10;
                output[count[index] - 1] = arr[i];
                count[index]--;
            }

            System.arraycopy(output, 0, arr, 0, arr.length);
        }
    }
}
