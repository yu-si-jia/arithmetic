package leetcode.uniqueOccurrences_1207;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author andor
 * @date 2020/10/28
 * @desc set记录下来
 */
public class Test02 {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < arr.length + 1; i++) {
            while (true){

            }
        }
        if (set.contains(count)) {
            return false;
        } else {
            set.add(count);
        }
        return true;
    }

}
