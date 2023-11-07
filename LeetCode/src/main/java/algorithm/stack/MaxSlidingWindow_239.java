package algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        MaxSlidingWindow_239 maxSlidingWindow239 = new MaxSlidingWindow_239();
        int[] ints = maxSlidingWindow239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monotonicQueue.push(nums[i]);
            } else {
                monotonicQueue.push(nums[i]);
                result.add(monotonicQueue.max());
                monotonicQueue.pop(nums[i - k + 1]);
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}

class MonotonicQueue {
    LinkedList<Integer> maxq = new LinkedList<>();
    public void push(int n) {
        while (!maxq.isEmpty() && maxq.getLast() < n) {
            maxq.pollLast();
        }
        maxq.addLast(n);
    }

    public int max() {
        return maxq.getFirst();
    }

    public void pop(int n) {
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}
