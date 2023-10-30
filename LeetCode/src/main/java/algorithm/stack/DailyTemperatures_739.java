package algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures_739 {
    public static void main(String[] args) {
        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = new DailyTemperatures_739().dailyTemperatures(a);
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            result[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return result;
    }
}
