package algorithm.array;

import java.util.Arrays;

public class Rotate_48 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("========================");
        new Rotate_48().rotate(a);
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] ints : matrix) {
            int left = 0, right = ints.length - 1;
            while (left < right) {
                int temp = ints[left];
                ints[left] = ints[right];
                ints[right] = temp;
                left++;
                right--;
            }
        }
    }
}
