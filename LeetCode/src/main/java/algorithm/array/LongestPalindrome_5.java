package algorithm.array;

public class LongestPalindrome_5 {

    public static void main(String[] args) {
        String a = "babad";
        String s = new LongestPalindrome_5().longestPalindrome(a);
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String r1 = palindrome(s, i, i);
            String r2 = palindrome(s, i, i + 1);
            result = result.length() > r1.length() ? result : r1;
            result = result.length() > r2.length() ? result : r2;
        }

        return result;
    }

    private String palindrome(String s, int left, int right) {
        while (left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
