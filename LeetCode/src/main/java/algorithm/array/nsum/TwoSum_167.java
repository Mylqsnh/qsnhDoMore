package algorithm.array.nsum;

public class TwoSum_167 {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] ints = new TwoSum_167().twoSum(a, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
