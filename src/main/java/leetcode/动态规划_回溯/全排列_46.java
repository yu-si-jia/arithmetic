package leetcode.动态规划_回溯;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HeJiageng
 * @date 2024/1/3
 * @desc
 */
public class 全排列_46 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, track, used);
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backTrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
