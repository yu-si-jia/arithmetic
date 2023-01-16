package arithstudy.twoSum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuSiJia
 * @date 2020/3/24
 * @desc
 */
public class Test01 {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i<nums.length; i++){
            for (int j = 1; j<nums.length; j++){
                if (nums[i]+nums[j] == target){
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
