class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,4,2};
        System.out.println(findPeak(nums1, 0, nums1.length-1));
        int[] nums2 = {1,2,3,5,4,2};
        System.out.println(findPeak(nums2, 0, nums2.length-1));
        int[] nums3 = {1,2,5,4,2};
        System.out.println(findPeak(nums3, 0, nums3.length-1));
        int[] nums4 = {1,5,4,2};
        System.out.println(findPeak(nums4, 0, nums4.length-1));
    }
    public static int findPeak(int[] nums, int left, int right) {
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
}
