public class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[2];
        for(int i = 0; i < nums.length; ++i) {
            int no = Math.max(dp[0], dp[1]);
            dp[1] = dp[0]+nums[i];
            dp[0] = no;
        }
        return Math.max(dp[0], dp[1]);
    }
}
