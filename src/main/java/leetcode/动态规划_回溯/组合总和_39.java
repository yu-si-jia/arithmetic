package leetcode.动态规划_回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ysj
 * @date 2024/1/17
 * @desc
 */
public class 组合总和_39 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    Integer trackSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        track(candidates, 0, target);
        return result;
    }

    public void track(int[] candidates,int start,  int target){
        if (trackSum > target){
            return;
        }
        if (trackSum == target){
            result.add(new ArrayList<>(track));
        }
        for (int i = start; i< candidates.length; i++){
            track.add(candidates[i]);
            trackSum += candidates[i];
            track(candidates, i, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
