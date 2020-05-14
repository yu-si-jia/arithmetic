package leetcode.minimum_length_encoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YuSiJia
 * @date 2020/3/28
 * @desc
 */
public class Test01 {
    public int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));
            }
        }

        int ans = 0;
        for (String word : good) {
            ans += word.length() + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        Test01 test01 = new Test01();
        System.out.println(test01.minimumLengthEncoding(words));
    }
}
