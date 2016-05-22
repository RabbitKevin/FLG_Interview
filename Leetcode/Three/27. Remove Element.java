public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while(i <= right) {
            if(nums[i] == val) {
                swap(nums, i, right);
                right--;
            }
            else {
                nums[left++] = nums[i++];
            }
        }
        return left;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
