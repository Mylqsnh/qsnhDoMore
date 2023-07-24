package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,1,0,9,8,6,10,20,13};
        System.out.println("before：");
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("\nafter：");
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int current = arr[i];
                int index = i;
                while (index >= gap && current < arr[index - gap]) {
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                arr[index] = current;
            }
            gap /= 2;
        }
    }
}
