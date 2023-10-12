package algorithm.array;

public class CarPooling_1094 {
    public static void main(String[] args) {
        boolean b = new CarPooling_1094().carPooling(new int[][]{{9, 0, 1}, {3, 3, 7}}, 5);
        System.out.println(b);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1001];

        for (int[] trip : trips) {
            result[trip[1]] += trip[0];
            if (trip[2] < 1001) {
                result[trip[2]] -= trip[0];
            }
        }

        int s = 0;
        for (int v : result) {
            s += v;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }
}
