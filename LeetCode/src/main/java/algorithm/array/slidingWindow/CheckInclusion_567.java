package algorithm.array.slidingWindow;

import java.util.HashMap;

public class CheckInclusion_567 {
    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        long l = System.currentTimeMillis();
        boolean b = new CheckInclusion_567().checkInclusion(s1, s2);
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(b);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.isEmpty() || s1 == null || s1.isEmpty()) return false;

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> result = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);

            right++;

            if (need.containsKey(c)) {
                result.put(c, result.getOrDefault(c, 0) + 1);
                if (result.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (need.get(d).equals(result.get(d))) {
                        valid--;
                    }
                    result.put(d, result.get(d) - 1);
                }
            }
        }

        return false;
    }
}
