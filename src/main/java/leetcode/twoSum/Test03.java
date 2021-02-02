package leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuSiJia
 * @date 2020/3/24
 * @desc
 */
public class Test03 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            int compant = target - nums[i];
            if (map.containsKey(compant)){
                return new int[]{i,map.get(compant)};
            }else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
