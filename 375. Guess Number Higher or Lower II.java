/*
    这是一开始写的代码，bottom-up interation. 用递归的方法写会更快，不需要重复运算底部的一些区间.
    但是...写recursion有被follow up的风险. So.....
*/
public class Solution {
    public int getMoneyAmount(int n) {
        //make dp[i][j] be the max cost between i - j where i <= j
        int[][] dp = new int[n][n];
        for(int i = 1; i <= n-1; ++i) {//gap
            for(int j = 0; j+i < n; ++j) {//left bound
                //[j, j+i]
                int min = Integer.MAX_VALUE;
                for(int mid = j; mid <= j+i; ++mid) {
                    int left = mid-1 < 0?0:dp[j][mid-1];
                    int right = mid+1 == n?0:dp[mid+1][j+i];
                    min = Math.min(min, mid+Math.max(left, right)+1);
                }
                dp[j][j+i] = min;
            }
        }
        return dp[0][n-1];
    }
}
/*
    后来看了下dis, 有人做了优化.
    不需要对一个区间的全部guess都做运算.
    从中点开始，因为在此之前，右侧一定比左侧大，那么max的结果是右侧，全局取min之后，在中点以前的运算都是无效的.
    有边界以左侧区间>=右侧为界.
    当超过这个界限之后，左侧>=右侧，max一定是左侧，全局取min后，从这个边界开始的所有运算都是无效的.
    另外当间隔宽度<=2时，不需要复杂运算.
    这样跑完是11ms...确实快了不少，然而比递归还是渣......
*/
public class Solution {
    public int getMoneyAmount(int n) {
        //make dp[i][j] be the max cost between i - j where i <= j
        int[][] dp = new int[n][n];
        for(int i = 1; i <= 2; ++i) {
            for(int j = 0; j+i < n; ++j) {
                dp[j][j+i] = j+i;
            }
        }
        for(int i = 3; i <= n-1; ++i) {//gap
            for(int j = 0; j+i < n; ++j) {//left bound
                //[j, j+i]
                int min = Integer.MAX_VALUE;
                int start = j+(i >> 1);
                for(int mid = start; mid <= j+i; ++mid) {
                    int left = mid-1 < 0?0:dp[j][mid-1];
                    int right = mid+1 == n?0:dp[mid+1][j+i];
                    min = Math.min(min, mid+Math.max(left, right)+1);
                    if(left >= right) break;
                }
                dp[j][j+i] = min;
            }
        }
        return dp[0][n-1];
    }
}
