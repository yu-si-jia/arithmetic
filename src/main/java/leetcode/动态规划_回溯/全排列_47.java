package leetcode.动态规划_回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HeJiageng
 * @date 2024/1/14
 * @desc
 */
public class 全排列_47 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList track = new LinkedList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        track(nums, track, used);
        return res;
    }


    public void track(int[] nums, LinkedList<Integer> track, boolean[] used){
        if (nums.length == track.size()){
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i< nums.length ; i++){
            if (used[i] == true){
                continue;
            }

            if (i > 0 && nums[i-1] != nums[i] && !used[i]){
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            track(nums,track,used);
            track.removeLast();
            used[i] = false;
        }
    }
}
