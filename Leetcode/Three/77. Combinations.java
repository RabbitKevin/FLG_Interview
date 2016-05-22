public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, 1, n, k, new ArrayList<Integer>());
        return result;
    }
    private void dfs(List<List<Integer>> result, int num, int n, int count, List<Integer> line) {
        if(count == 0) {
            result.add(new ArrayList<Integer>(line));
            return;
        }
        for(int start = num; start <= n-count+1; ++start) {
            line.add(start);
            dfs(result, start+1, n, count-1, line);
            line.remove(line.size()-1);
        }
    }
}
