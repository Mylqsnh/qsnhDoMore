package algorithm.array.binarySearch;

import java.util.Random;

public class PickIndex_528 {
    public static void main(String[] args) {

        PickIndex_528 solution = new PickIndex_528(new int[]{1, 3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    int[] perSum;
    Random random = new Random();

    public PickIndex_528(int[] w) {
        int length = w.length;
        perSum = new int[length + 1];
        perSum[0] = 0;
        for (int i = 1; i < perSum.length; i++) {
            perSum[i] = perSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int length = perSum.length;
        int target = random.nextInt(perSum[length - 1]) + 1;
        return leftBound(perSum, target) - 1;
    }

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
