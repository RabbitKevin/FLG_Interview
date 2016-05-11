/*
    常规DP解法
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        int row = dp.length;//s
        int col = dp[0].length;//p
        dp[0][0] = true;
        for(int i = 1; i < col; ++i) {
            dp[0][i] = (p.charAt(i-1) == '*' && dp[0][i-1]);
        }
        for(int i = 1; i < row; ++i) {
            for(int j = 1; j < col; ++j) {
                char x = p.charAt(j-1);
                if(x == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(x == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else {
                    if(s.charAt(i-1) == x) dp[i][j] = dp[i-1][j-1];
                    else dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

/*
    2-Pointer, Greedy
    http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
    https://leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, match = 0, lastStar = -1;
        while(i < s.length()) {
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            }
            else if(j < p.length() && p.charAt(j) == '*') {
                lastStar = j;
                j++;
                match = i;
            }
            //Has backup point, not match
            else if(lastStar != -1) {
                j = lastStar+1;
                match++;//advance s pointer
                i = match;
            }
            else return false;
        }
        while(j < p.length()) {
            if(p.charAt(j++) != '*') return false;
        }
        return true;
    }
}
