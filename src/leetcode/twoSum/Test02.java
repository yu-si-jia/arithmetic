package leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuSiJia
 * @date 2020/3/24
 * @desc
 */
public class Test02 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> num = new HashMap<>();
        for (int ignored :nums){
            num.put(nums[ignored],ignored);
        }
        for (int i = 0; i< nums.length; i++){
            int compant = target - nums[i];
            if (num.containsKey(compant)&&num.get(compant)!=i){
                return new int[] { i, num.get(compant) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
