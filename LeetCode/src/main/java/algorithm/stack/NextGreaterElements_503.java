package algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements_503 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 3};
        int[] ints = new NextGreaterElements_503().nextGreaterElements(a);
        System.out.println(Arrays.toString(ints));
    }

    int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;
    }
}
