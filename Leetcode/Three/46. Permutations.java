public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        dfs(result, nums, isUsed, new ArrayList<Integer>());
        return result;
    }
    private void dfs(List<List<Integer>> result, int[] nums, boolean[] isUsed, List<Integer> line) {
        if(line.size() == nums.length) {
            result.add(new ArrayList<Integer>(line));
            return;
        }
        for(int i = 0; i <nums.length; ++i) {
            if(isUsed[i]) continue;
            isUsed[i] = true;
            line.add(nums[i]);
            dfs(result, nums, isUsed,line);
            isUsed[i] = false;
            line.remove(line.size()-1);
        }
    }
}
