class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        rotateArray(nums, -2);
        printArray(nums);
    }
    public static void rotateArray(int[] nums, int k) {
        if(k < 0) {
            k = nums.length-(Math.abs(k)%nums.length);
        }
        else k = k % nums.length;
        for(int i = 0; i+k < nums.length; ++i) {
            int tmp = nums[i];
            nums[i] = nums[i+k];
            nums[i+k] = tmp;
        }
    }
    public static void printArray(int[] nums) {
        for(int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
