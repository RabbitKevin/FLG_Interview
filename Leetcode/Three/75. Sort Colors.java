public class Solution {
    public void sortColors(int[] nums) {
        int ptr_red = 0;
        int ptr_blue = nums.length-1;
        int i = 0;
        while(i <= ptr_blue) {
            //red
            if(nums[i] == 0) {
                swap(nums, i, ptr_red);
                ptr_red++;
                i++;
            }
            else if(nums[i] == 2) {
                swap(nums, i, ptr_blue);
                ptr_blue--;
            }
            else i++;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
