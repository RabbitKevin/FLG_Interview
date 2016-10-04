/*
    这题拿到第一反应就是dp, 但是DP的复杂度是O(n^2).
    再看题，其实就是将没一个降/升序压缩到只剩第一个和最后一个

    那么如何写出优雅的代码来做这个处理, 同时要解决前后元素相等的情况.
    1. 当一个序列完成后，下一个开始的序列必然是相反的，不然一定还在前一个序列;
    2. 算一个序列的时候，出现相等的情况当作序列来处理;
    3. 假如一开始，两个元素就相等，那么必须去掉一个;

    代码是看的 https://www.hrwhisper.me/leetcode-wiggle-subsequence/
*/
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        int num = 1;
        for(int i = 0, j = 1; j < nums.length; i = j, ++j) {
            if(nums[i] < nums[j]) {
                num++;
                while(j+1<nums.length && nums[j+1] >= nums[j]) ++j;
            }
            else if(nums[i] > nums[j]) {
                num++;
                while(j+1 < nums.length && nums[j+1] <= nums[j]) ++j;
            }
        }
        return num;
    }
}
