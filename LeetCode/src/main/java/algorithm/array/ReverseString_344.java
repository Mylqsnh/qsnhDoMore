package algorithm.array;

public class ReverseString_344 {

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new ReverseString_344().reverseString(s);

        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
