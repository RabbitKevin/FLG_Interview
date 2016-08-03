public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        List<Integer> line = triangle.get(n-1);
        for(int i = 0; i < n; ++i) {
            dp[i] = line.get(i);
        }
        //-------------------------//
        for(int i = n-2; i >= 0; --i) {
            line = triangle.get(i);
            for(int j = 0; j < i+1; ++j) {
                dp[j] = Math.min(dp[j], dp[j+1])+line.get(j);
            }
        }
        return dp[0];
    }
}
