package algorithm.array.slidingWindow.rabinKarp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindRepeatedDnaSequences_187 {
    public static void main(String[] args) {
        String a = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedDnaSequences = new FindRepeatedDnaSequences_187().findRepeatedDnaSequences(a);
        System.out.println(repeatedDnaSequences);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        HashSet<Integer> seen = new HashSet<>();

        HashSet<String> result = new HashSet<>();

        int L = 10;
        int R = 4;
        int RL = (int) Math.pow(R, L - 1);

        int windowHash = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            windowHash = windowHash * R + nums[right];
            right++;
            if (right - left == L) {
                if (seen.contains(windowHash)) {
                    result.add(s.substring(left, right));
                } else {
                    seen.add(windowHash);
                }
                windowHash = windowHash - nums[left] * RL;
                left++;
            }
        }

        return new LinkedList<>(result);
    }
}
