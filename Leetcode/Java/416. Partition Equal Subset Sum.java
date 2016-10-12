public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum+=num;
        }
        if((sum&1) == 1) return false;
        int size = sum >> 1;
        boolean[] dp = new boolean[size+1];
        dp[0] = true;//empty is always true
        for(int num : nums) {
            for(int i = size; i >= num; --i) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[size];
    }
}
