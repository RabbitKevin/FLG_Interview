/*
    观察规律. 2，3是唯一两个不可拆分的数，拆分反而会比不拆更小.
    所以任意一个数，都拆成2, 3.
    当没有2时，增加1，拿一个3出来，拆成2个2;
    当有2因子时，提一个2出来，＋1， 变做3;
*/
public class Solution {
    public int integerBreak(int n) {
        //# of 2, # of 3
        if(n < 4) return n-1;
        int[] dp = {2,0};
        //--------------//
        for(int i = 5; i <= n; ++i) {
            if(dp[0] == 0) {
                dp[0] = 2;
                dp[1]--;
            }
            else {
                dp[0]--;
                dp[1]++;
            }
        }
        return (1 << dp[0])*(int)(Math.pow(3, dp[1]));
    }
}
