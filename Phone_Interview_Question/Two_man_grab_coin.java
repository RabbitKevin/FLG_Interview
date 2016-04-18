class Solution {
  public static void main(String[] args) {
    int[] nums = {3,7,2,1};
    int max = dp(nums);
    System.out.println(max);
  }
  public static int dp(int[] nums) {
    int size = nums.length;
    int[][] dp = new int[size][size];
    //----gap----//
    for(int i = 0; i < size; ++i) {
      dp[i][i] = nums[i];
    }
    for(int i = 0; i+1 < size; ++i) {
      dp[i][i+1] = Math.max(nums[i], nums[i+1]);
    }
    for(int i = 2; i < size; ++i) {
      //left bound
      for(int j = 0; j+i < size; ++j) {
        int one = nums[j]+(nums[j+1] < nums[j+i]?dp[j+1][j+i-1]:dp[j+2][j+i]);
        int two = nums[j+i]+(nums[j] < nums[j+i-1]?dp[j][i+j-2]:dp[j+1][j+i-1]);
        dp[j][i+j] = Math.max(one, two);
      }
    }
    return dp[0][size-1];
  }
}
