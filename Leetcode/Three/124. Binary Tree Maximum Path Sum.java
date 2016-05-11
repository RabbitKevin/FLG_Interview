/*
    第一次做的时候，同时维护了三个变量， leftSub, across root, rightSub,
    超时了........
*/
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
    /*
        1. leftSub
        2. contain root
        3. rightSub
    */
    private int dfs(TreeNode root, int[] max) {
        if(root == null) return 0;
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        int result = Math.max(Math.max(left, right)+root.val, root.val);
        max[0] = Math.max(Math.max(result, root.val+left+right), max[0]);
        return result;
    }
}
