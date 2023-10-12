package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords_151 {
    public static void main(String[] args) {
        String s = " qsnh hello word";
        String s1 = new ReverseWords_151().reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {

        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
