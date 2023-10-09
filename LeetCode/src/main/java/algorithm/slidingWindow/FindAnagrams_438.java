package algorithm.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams_438 {

    public static void main(String[] args) {
        String a = "cbaebabacd";
        List<Integer> abc = new FindAnagrams_438().findAnagrams(a, "abc");
        System.out.println(abc);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) return List.of();
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> has = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                has.put(c, has.getOrDefault(c, 0) + 1);
                if (has.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            right++;

            while (right - left >= p.length()) {
                char c1 = s.charAt(left);
                if (need.size() == valid) {
                    result.add(left);
                }
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(has.get(c1))) {
                        valid--;
                    }
                    has.put(c1, has.get(c1) - 1);
                }
                left++;
            }
        }

        return result;
    }
}
