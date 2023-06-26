package leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ysj
 * @date 2023/6/26
 * @desc 151. 反转字符串中的单词
 */
public class 反转字符串中的单词_151 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
