package arithstudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ysj
 * @date 2022/3/2
 * @desc 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis_22 {


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        return def(ans, cur, 0, 0, n);

    }

    private List<String> def(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return ans;
        }

        if (open < max) {
            cur.append('(');
            def(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(')');
            def(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        return ans;
    }
}
