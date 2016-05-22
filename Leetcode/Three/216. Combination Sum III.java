public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(k > 9) return result;
        dfs(result, 1, k, n, new ArrayList<Integer>());
        return result;
    }
    private void dfs(List<List<Integer>> result, int start, int k, int n, List<Integer> line) {
        if(n == 0 && k == 0) {
            result.add(new ArrayList<Integer>(line));
            return;
        }
        if(n <= 0 || k <= 0) return;
        for(int i = start; i <= 10-k; ++i) {
            line.add(i);
            dfs(result, i+1, k-1, n-i,line);
            line.remove(line.size()-1);
        }
    }
}
