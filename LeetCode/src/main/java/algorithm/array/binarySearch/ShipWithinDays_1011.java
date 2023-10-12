package algorithm.array.binarySearch;

public class ShipWithinDays_1011 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 2, 4, 1, 4};
        int i = new ShipWithinDays_1011().shipWithinDays(a, 3);
        System.out.println(i);
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
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
