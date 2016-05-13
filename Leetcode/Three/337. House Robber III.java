public class Solution {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }
    private int[] dfs(TreeNode root) {
        int[] result = new int[2];
        if(root == null) return result;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        result[0] = Math.max(left[0], left[1])+Math.max(right[0], right[1]);
        result[1] = root.val+left[0]+right[0];
        return result;
    }
}
