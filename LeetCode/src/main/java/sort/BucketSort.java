package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,1,0,9,8,6,10,20,13};
        System.out.println("before：");
        System.out.println(Arrays.toString(arr));
        bucketSort(arr);
        System.out.println("\nafter：");
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr) {
        int n = arr.length;
        int maxVal = getMaxValue(arr);
        int minVal = getMinValue(arr);

        // 计算桶的个数，这里取决于待排序数组的范围
        int bucketCount = (maxVal - minVal) / n + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // 将元素分配到对应的桶中
        for (int num : arr) {
            int bucketIndex = (num - minVal) / n;
            buckets.get(bucketIndex).add(num);
        }

        // 对每个桶中的元素进行排序（可以使用插入排序、快速排序等）
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 合并桶中的元素得到最终有序数组
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static int getMinValue(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
