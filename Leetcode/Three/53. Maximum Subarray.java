public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int dp = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            if(dp < 0) dp = nums[i];
            else dp+=nums[i];
            max = Math.max(dp, max);
        }
        return max;
    }
}
