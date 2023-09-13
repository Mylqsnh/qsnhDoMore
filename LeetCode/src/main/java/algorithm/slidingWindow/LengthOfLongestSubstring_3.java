package algorithm.slidingWindow;

import java.util.HashMap;

public class LengthOfLongestSubstring_3 {

    public static void main(String[] args) {
        String a = "abcabcbb";
        int i = new LengthOfLongestSubstring_3().lengthOfLongestSubstring(a);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                left++;
                window.put(c1, window.get(c1) - 1);

            }
            result = Math.max(result, right - left);
        }

        return result;
    }
}
