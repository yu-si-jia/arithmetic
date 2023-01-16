package arithstudy.xor_operation_1486;

/**
 * @author andor
 * @date 2021/5/7
 * @desc
 */
class Solution {
    public int xorOperation(int n, int start) {
        int result = 0;
        int[] nums = new int[n];
        for (int i = 0; i<n; i++){
            nums[i] = start + 2*i;
            result = result^nums[i];
        }
        return result;

    }
}
