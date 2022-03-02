package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ysj
 * @date 2022/2/7
 * @desc 17. 电话号码的字母组合
 */
public class LetterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrack(result, phoneMap, digits, 0, new StringBuffer());

        return result;
    }


    // index 输入的第几位
    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    backtrack(combinations, phoneMap, digits, index + 1, combination);
                    // 在判断长度的时候已经把上一次的结果添加了，将第二次拼接
                    combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        new LetterCombinations_17().letterCombinations("23");
    }

}
