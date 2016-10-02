/*
    这题百花齐放...各种写法有不同的想法
*/

/*
    Two pointer
    If there is a character in s that is not in t, t has to traverse all index,
    time consuming
*/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(t.length() < s.length()) return false;
        int sPtr = 0;
        for(char x : t.toCharArray()) {
            if(x == s.charAt(sPtr)) sPtr++;
            if(sPtr == s.length()) return true;
        }
        return false;
    }
}

/*
    Recursion and decrease size of t,
    clean code, and decrease the size of t
*/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0; i < t.length(); i += 1) {
            if (t.charAt(i) == s.charAt(0)) return isSubsequence(s.substring(1), t.substring(i + 1));
        }
        return false;
    }
}

/*
    DP, crazy idea(from tag)
    not necessary
*/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int pre = 0;
        int next = 1;
        boolean[][] dp = new boolean[2][t.length()+1];
        for(int i = 0; i <= t.length(); ++i) {
            dp[0][i] = true;
        }
        for(int j = 1; j <= s.length(); ++j) {
            for(int k = 1; k <= t.length(); ++k) {
                if(j > k) dp[next][k] = false;
                else if(s.charAt(j-1) == t.charAt(k-1)) {
                    dp[next][k] = dp[pre][k-1] || dp[next][k-1];
                }
                else dp[next][k] = dp[next][k-1];
            }
            next =next ^ 1;
            pre = pre ^ 1;
        }
        return dp[pre][t.length()];
    }
}

/*
    Binary search and handle multiple s input.
    When dealing with multiple s and single t, we make think about cache info of t

    Idea is very simple, we create a character map for t and record index for each
    character in ascending order.
    Every time, check char in s, find the minimum value for that char in map.
*/
