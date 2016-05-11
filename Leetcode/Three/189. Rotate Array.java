/*
    Test case里没有关于k<0的情况，也可以考虑.
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0) return;
        if(k > 0) k = k % nums.length;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }
}
