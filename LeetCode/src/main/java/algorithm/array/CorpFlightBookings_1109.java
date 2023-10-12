package algorithm.array;

import java.util.Arrays;

public class CorpFlightBookings_1109 {

    public static void main(String[] args) {
        int[] ints = new CorpFlightBookings_1109().corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
        System.out.println(Arrays.toString(ints));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            result[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                result[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < result.length; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}