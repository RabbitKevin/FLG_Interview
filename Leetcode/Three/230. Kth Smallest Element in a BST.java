public class Solution {
    int count = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    private void dfs(TreeNode root, int k) {
        if(root == null || count == k) return;
        dfs(root.left, k);
        if(count == k-1) {
            res = root.val;
        }
        count++;
        dfs(root.right, k);
    }
}
