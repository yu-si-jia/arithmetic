package arithstudy.uniqueOccurrences_1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author andor
 * @date 2020/10/28
 * @desc leetcode  1207
 */
public class Test01 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        HashSet set = new HashSet(map.values());
        return map.size() ==set.size();

    }
}
