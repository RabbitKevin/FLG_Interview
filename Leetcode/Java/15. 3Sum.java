public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-2;) {
            int j = i+1;
            int z = nums.length-1;
            while(j < z) {
                int sum = nums[i]+nums[j]+nums[z];
                if(sum < 0) ++j;
                else if(sum > 0) --z;
                else {
                    List<Integer> line = new ArrayList<>();
                    line.add(nums[i]);
                    line.add(nums[j]);
                    line.add(nums[z]);
                    result.add(line);
                    ++j;
                    --z;
                    while(j < z && nums[j] == nums[j-1]) ++j;
                    while(j < z && nums[z] == nums[z+1]) --z;
                }
            }
            ++i;
            while(i < nums.length && nums[i] == nums[i-1]) ++i;
        }
        return result;
    }
}
