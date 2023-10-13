package algorithm.array.binarySearch;

public class SplitArray_410 {
    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 5, 18};
        int i = new SplitArray_410().splitArray(a, 2);
        System.out.println(i);
    }

    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    int f(int[] weights, int x) {
        int day = 0;
        for (int i = 0; i < weights.length;) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            day++;
        }

        return day;
    }
}
