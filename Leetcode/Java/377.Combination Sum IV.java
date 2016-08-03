public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i <= target; ++i) {
            for(int num : nums) {
                int tmp = i-num;
                if(tmp >= 0) dp[i]+=dp[tmp];
            }
        }
        return dp[target];
    }
}

/*
    Q:
        Follow up
        What if negative numbers are allowed in the given array?
        How does it change the problem?
        What limitation we need to add to the question to allow negative numbers?
    A:
*/
