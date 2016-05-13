public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
            int mid = (left+right) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
}
