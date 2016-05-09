public class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = {0};
        if(root != null) dfs(root, 0, sum);
        return sum[0];
    }

    private void dfs(TreeNode root, int num, int[] sum) {
        if(root.left == null && root.right == null) {
            sum[0]+=10*num+root.val;
            return;
        }
        num = 10*num+root.val;
        if(root.left != null) dfs(root.left, num, sum);
        if(root.right != null) dfs(root.right, num, sum);
    }
}
