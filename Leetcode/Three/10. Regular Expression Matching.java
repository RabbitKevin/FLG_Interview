/*
    2D, could be optimize by rotating buffer
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        int row = dp.length;
        int col = dp[0].length;
        for(int i = 1; i < col; ++i) {
            dp[0][i] = p.charAt(i-1) == '*' && dp[0][i-2];
        }
        for(int i = 1; i < row; ++i) {
            for(int j = 1; j < col; ++j) {
                char x = p.charAt(j-1);
                if(x == '.') dp[i][j] = dp[i-1][j-1];
                else if(x == '*') {
                    dp[i][j] = dp[i][j-2] || ((p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)) && dp[i-1][j]);
                }
                else dp[i][j] = p.charAt(j-1) == s.charAt(i-1) && dp[i-1][j-1];
            }
        }
        return dp[s.length()][p.length()];
    }
}
