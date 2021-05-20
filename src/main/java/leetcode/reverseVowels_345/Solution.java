package leetcode.reverseVowels_345;

/**
 * @author andor
 * @date 2021/5/19
 * @desc
 */
public class Solution {
    public String reverseVowels(String s) {

        int n = s.length();
        int left = 0, right = n - 1;
        char[] sChar = s.toCharArray();

        while (left < right) {

            char a = sChar[left];
            char b = sChar[right];

            if (!isVowel(a)) {

                left++;
                continue;
            } else if (!isVowel(b)) {

                right--;
                continue;
            } else {

                char c = sChar[left];
                sChar[left] = sChar[right];
                sChar[right] = c;
            }
            left++;
            right--;
        }
        return new String(sChar);
    }

    private boolean isVowel(char c) {

        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' || c == 'A' ||
                c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }
    
}
