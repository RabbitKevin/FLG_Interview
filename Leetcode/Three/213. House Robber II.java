/*
    同时维护4个状态
*/
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[4];
        dp[0] = nums[1];
        dp[1] = nums[0];
        dp[2] = nums[2];
        dp[3] = nums[2]+nums[0];
        for(int i = 3 ; i < nums.length; ++i) {
            int one = Math.max(dp[0], dp[2]);
            int two = Math.max(dp[1], dp[3]);
            int three = dp[0]+nums[i];
            int four = dp[1]+nums[i];
            dp[0] = one;
            dp[1] = two;
            dp[2] = three;
            dp[3] = four;
        }
        return Math.max(Math.max(dp[1], dp[2]), dp[0]);
    }
}
