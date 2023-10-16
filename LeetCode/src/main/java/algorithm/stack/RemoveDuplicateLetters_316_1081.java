package algorithm.stack;

import java.util.Stack;

public class RemoveDuplicateLetters_316_1081 {
    public static void main(String[] args) {
        String s = "bcabc";
        String s1 = new RemoveDuplicateLetters_316_1081().removeDuplicateLetters(s);
        System.out.println(s1);
    }

    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] present = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;

            if (present[c]) continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) break;
                present[stack.pop()] = false;
            }

            stack.push(c);
            present[c] = true;
        }

        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
