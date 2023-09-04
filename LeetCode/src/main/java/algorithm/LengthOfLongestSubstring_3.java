package algorithm;

import java.util.HashMap;

public class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {

        int max = new LengthOfLongestSubstring_3().lengthOfLongestSubstring("abcdeacfg");

        assert max == 6;
        System.out.println(max);

    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }

            max = Math.max(max, i - start + 1);
            map.put(c, i);
        }

        return max;
    }
}
