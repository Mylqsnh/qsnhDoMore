package sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 1, 0, 9, 8, 6, 10, 20, 13};
        System.out.println("before：");
        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println("\nafter：");
        System.out.println(Arrays.toString(arr));
    }

    private static void countSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 基本情况，不需要排序
        }

        // 找出最大值和最小值
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // 创建辅助数组，并统计每个元素出现的次数
        int[] countArray = new int[max - min + 1];
        for (int num : arr) {
            countArray[num - min]++;
        }

        // 重构排序后的数组
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                arr[index] = i + min;
                index++;
                countArray[i]--;
            }
        }
    }
}
