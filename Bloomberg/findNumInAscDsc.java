import java.util.*;
/*
    Find if there exist a number in a ascending and dscending array
*/
class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,4,2};
        int target = 6;
        System.out.println(findExistNum(nums1, target));
    }
    public static boolean findExistNum(int[] nums, int num) {
        int peak = findPeak(nums, 0, nums.length-1);
        boolean left = bst(nums, 0, peak, num, true);
        boolean right = bst(nums, peak+1, nums.length-1, num, false);
        System.out.println("left: "+left+" right:"+right);
        return left || right;
    }
    private static int findPeak(int[] nums, int left, int right) {
        while(left < right) {
            int mid = left+((right-left) >> 1);
            if(nums[mid+1] > nums[mid]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    private static boolean bst(int[] nums, int left, int right, int num, boolean ordered) {
        while(left < right) {
            int mid = (left+right)>>1;
            if(nums[mid] == num) return true;
            if(ordered ^ (nums[mid] > num)) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}
