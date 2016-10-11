public class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int index = -1;
        int i =1;
        for(int j = 0; j < nums.length; ++j) {
            if(nums[j] == target) {
                if(random.nextInt(i) == 0) index = j;
                i++;
            }
        }
        return index;
    }
}
