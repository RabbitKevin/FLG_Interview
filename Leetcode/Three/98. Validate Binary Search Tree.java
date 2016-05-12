public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, (long)Integer.MIN_VALUE-1, (long)Integer.MAX_VALUE+1);
    }

    private boolean dfs(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val < min || root.val > max) return false;
        return dfs(root.left, min, (long)root.val-1) && dfs(root.right, (long)root.val+1, max);
    }
}
