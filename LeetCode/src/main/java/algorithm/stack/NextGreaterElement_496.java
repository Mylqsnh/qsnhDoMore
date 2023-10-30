package algorithm.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2}, nums2 = new int[]{1, 3, 4, 2};
        NextGreaterElement_496 nextGreaterElement496 = new NextGreaterElement_496();
        int[] ints = nextGreaterElement496.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = nextGreaterElement(nums2);
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            greaterMap.put(nums2[i], greater[i]);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = greaterMap.get(nums1[i]);
        }
        return result;
    }

    public int[] nextGreaterElement(int[] nums1) {
        int n = nums1.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums1[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums1[i]);
        }
        return result;
    }
}
