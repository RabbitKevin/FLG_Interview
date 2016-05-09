public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) dfs(root, sum, result, new ArrayList<Integer>());
        return result;
    }
    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                path.add(root.val);
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(root.val);
        if(root.left != null) dfs(root.left, sum-root.val, result, path);
        if(root.right != null) dfs(root.right, sum-root.val, result, path);
        path.remove(path.size()-1);
    }
}
