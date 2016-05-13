public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = findLeft(nums,target);
        int right = findRight(nums, target);
        if(left < 0 || left > nums.length || (left == right && nums[left] != target)) {
            result[0] = -1;
            result[1] = -1;
        }
        else {
            result[0] = left;
            result[1] = right;
        }
        return result;
    }
    private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = (left+right) >> 1;
            if(target < nums[mid]) right = mid-1;
            else if(target > nums[mid]) left = mid+1;
            else right = mid;
        }
        return left;
    }
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = (left+right) >> 1;
            if(target < nums[mid]) right = mid-1;
            else if(target > nums[mid]) left = mid+1;
            else {
                if(mid+1 == nums.length || nums[mid+1] != target) return mid;
                else left = mid+1;
            }
        }
        return left;
    }
}
