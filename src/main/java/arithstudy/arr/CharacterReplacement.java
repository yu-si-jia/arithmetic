package arithstudy.arr;

import java.util.Arrays;

/**
 * @author andor
 * @date 2021/2/20
 * @desc 424. 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换k次
 * <p>
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        if(n==0){
            return 0;
        }
        int left = 0, right = 0;
        num[s.charAt(right)-'A']++;
        int res=1;
        while (right<n){
            int maxn=1;
            for(int i=0;i<26;i++){
                maxn=Math.max(maxn,num[i]);
            }
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }else {
                res = Math.max(res, right - left + 1);
                right++;
                if (right == n) break;
                num[s.charAt(right) - 'A']++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        characterReplacement.characterReplacement("AABABBA",1);
    }
}

