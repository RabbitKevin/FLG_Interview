public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new boolean[nums.length], new ArrayList<Integer>());
        return result;
    }
    private void dfs(List<List<Integer>> result, int[] nums, boolean[] used, List<Integer> line) {
        if(line.size() == nums.length) {
            result.add(new ArrayList<Integer>(line));
            return;
        }
        for(int i = 0; i < nums.length; ++i) {
            if(used[i]) continue;
            line.add(nums[i]);
            used[i] = true;
            dfs(result, nums, used, line);
            line.remove(line.size()-1);
            used[i] = false;
            while(i < nums.length-1 && nums[i+1] == nums[i]) ++i;
        }
    }
}
