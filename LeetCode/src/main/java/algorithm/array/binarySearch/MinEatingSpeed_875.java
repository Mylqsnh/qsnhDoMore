package algorithm.array.binarySearch;

public class MinEatingSpeed_875 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 6, 7, 11};
        int i = new MinEatingSpeed_875().minEatingSpeed(a, 8);
        System.out.println(i);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    long f(int[] piles, int h) {
        long result = 0;
        for (int i = 0; i < piles.length; i++) {
            result += piles[i] / h;
            if (piles[i] % h > 0) {
                result++;
            }
        }
        return result;
    }
}
