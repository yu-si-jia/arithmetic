package leetcode.mystack;

import java.util.*;

/**
 * @author ysj
 * @date 2023/2/27
 * @desc 20：有效的括号
 */
public class IsValid_20 {

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
    }};


    public static boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        Deque<Character> stack = new LinkedList<>();
        stack.push('-');
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if ( map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size()==1;
    }


    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));
    }
}
