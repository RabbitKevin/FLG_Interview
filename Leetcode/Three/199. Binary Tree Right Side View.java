public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        int[] depth = {0};
        dfs(root, depth, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int[] depth, int cur, List<Integer> result) {
        if(root == null) return;
        if(cur >= depth[0]) {
            result.add(root.val);
            depth[0]++;
        }
        dfs(root.right, depth, cur+1, result);
        dfs(root.left, depth, cur+1, result);
    }
}
