package algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> integers = new SpiralOrder_54().spiralOrder(a);
        System.out.println(integers);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        int upperBound = 0, lowerBound = n - 1;
        int leftBound = 0, rightBound = m - 1;

        ArrayList<Integer> result = new ArrayList<>();

        while (result.size() < m * n) {
            if (upperBound <= lowerBound) {
                for (int j = leftBound; j <= rightBound; j++) {
                    result.add(matrix[upperBound][j]);
                }
                upperBound++;
            }
            if (leftBound <= rightBound) {
                for (int j = upperBound; j <= lowerBound; j++) {
                    result.add(matrix[j][rightBound]);
                }
                rightBound--;
            }
            if (upperBound <= lowerBound) {
                for (int j = rightBound; j >= leftBound; j--) {
                    result.add(matrix[lowerBound][j]);
                }
                lowerBound--;
            }
            if (leftBound <= rightBound) {
                for (int j = lowerBound; j >= upperBound; j--) {
                    result.add(matrix[j][leftBound]);
                }
                leftBound++;
            }
        }

        return result;
    }
}
