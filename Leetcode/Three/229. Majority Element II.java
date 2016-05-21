public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] candidates = new int[2];
        int[] counts = new int[2];
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] == candidates[0]) counts[0]++;
            else if(nums[i] == candidates[1]) counts[1]++;
            else if(counts[0] == 0) {
                candidates[0] = nums[i];
                counts[0] = 1;
            }
            else if(counts[1] == 0) {
                candidates[1] = nums[i];
                counts[1] = 1;
            }
            else {
                counts[0]--;
                counts[1]--;
            }
        }
        //---------------------------------//
        counts[0] = 0;
        counts[1] = 0;
        for(int num : nums) {
            if(num == candidates[0]) counts[0]++;
            else if(num == candidates[1]) counts[1]++;
        }
        if(counts[0] > nums.length/3) result.add(candidates[0]);
        if(counts[1] > nums.length/3) result.add(candidates[1]);
        return result;
    }
}
