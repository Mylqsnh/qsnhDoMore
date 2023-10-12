package algorithm.array;

import java.util.Arrays;

public class GenerateMatrix_59 {
    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix_59().generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int temp = 1;
        int upperBound = 0, lowerBound = n - 1;
        int leftBound = 0, rightBound = n - 1;

        while (temp <= n * n) {

            if (upperBound <= lowerBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    nums[upperBound][j] = temp++;
                }
                upperBound++;
            }

            if (leftBound <= rightBound) {
                for (int j = upperBound; j <= lowerBound; j++) {
                    nums[j][rightBound] = temp++;
                }
                rightBound--;
            }

            if (upperBound <= lowerBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    nums[lowerBound][j] = temp++;
                }
                lowerBound--;
            }

            if (leftBound <= rightBound) {
                for (int j = lowerBound; j >= upperBound; j--) {
                    nums[j][leftBound] = temp++;
                }
                leftBound++;
            }
        }

        return nums;
    }
}
