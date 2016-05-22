public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, 0, candidates, target, new ArrayList<Integer>());
        return result;
    }
    private void dfs(List<List<Integer>> result, int index, int[] candidates, int target, List<Integer> line) {
        if(target < 0) return;
        else if(target == 0) {
            result.add(new ArrayList<Integer>(line));
            return;
        }
        else {
            for(int i = index; i < candidates.length && candidates[i] <= target; ++i) {
                line.add(candidates[i]);
                dfs(result, i, candidates, target-candidates[i], line);
                line.remove(line.size()-1);
            }
        }
    }
}
