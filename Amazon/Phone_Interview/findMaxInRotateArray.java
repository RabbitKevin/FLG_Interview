class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{8,8,8,9,9,8};
        System.out.println(findMaxDistinct(nums, 0, nums.length-1));
        System.out.println(findMinDistinct(nums, 0, nums.length-1));
        System.out.println(findMaxDuplicate(nums, 0, nums.length-1));
    }
    public static int findMaxDistinct(int[] nums, int left, int right) {
        while(left < right) {
            if(nums[left] < nums[right]) return nums[right];
            int mid = (left+right)/2;
            if(nums[mid] > nums[left]) left = mid;
            else right = mid-1;
        }
        return nums[left];
    }
    public static int findMinDistinct(int[] nums, int left, int right) {
        while(left < right) {
            if(nums[left] < nums[right]) return nums[left];
            int mid = left+(right-left)/2;
            if(nums[mid] >= nums[left]) left = mid+1;
            else right = mid;
        }
        return nums[left];
    }
    public static int findMaxDuplicate(int[] nums, int left, int right) {
        while(left < right) {
            if(nums[left] < nums[right]) return nums[right];
            int mid = (left+right)/2;
            if(nums[mid] > nums[left]) left = mid;
            else if(nums[mid] < nums[left]) right = mid-1;
            else return Math.max(findMaxDuplicate(nums,left,mid), findMaxDuplicate(nums,mid+1, right));
    }
        return nums[left];
    }
}
