/*
    递归做法超时了
*/
public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;//dummy
        dp[1] = 1;//first
        for(int i = 2; i <= s.length(); ++i) {
            char x = s.charAt(i-2);
            if(s.charAt(i-1) == '0') {
                if(x == '1' || x == '2') dp[i]+=dp[i-2];
            }
            else {
                dp[i]+=dp[i-1];//single
                if(x == '1' || (x == '2' && s.charAt(i-1) <= '6')) dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
