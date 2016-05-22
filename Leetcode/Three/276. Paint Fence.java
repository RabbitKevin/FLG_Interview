public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        int[] dp = new int[2];
        dp[0] = 1;
        for(int i = 1; i < n; ++i) {
            int tmp = dp[0];
            dp[0] = (dp[1]+dp[0])*(k-1);
            dp[1] = tmp;
        }
        return k*(dp[0]+dp[1]);
    }
}
