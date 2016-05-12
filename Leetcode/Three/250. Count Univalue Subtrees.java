/*
    同时维持两个状态
*/
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] result = help(root);
        return result[1]+result[0];
    }
    /*
        [root, non-root]
    */
    private int[] help(TreeNode root) {
        if(root == null) return new int[]{0,0};
        int[] left = help(root.left);
        int[] right = help(root.right);
        int[] result = new int[2];
        result[1] = left[0]+left[1]+right[0]+right[1];
        if(root.left != null && root.right != null) {
            if(root.val == root.left.val && root.val == root.right.val && left[0] == 1 && right[0] == 1) result[0] = 1;
        }
        else if(root.left != null) {
            if(root.val == root.left.val && left[0] == 1) result[0] = 1;
        }
        else if(root.right != null) {
            if(root.val == root.right.val && right[0] == 1) result[0] = 1;
        }
        else result[0] = 1;
        return result;
    }
}
/*
    第二版，第一版维持住了两个状态，但是其实不需要，因为所有的subtree其实就是每一个点都做root时候，可能的uni-value
    叠加
*/
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] sum = {0};
        dfs(root, sum);
        return sum[0];
    }
    private boolean dfs(TreeNode root, int[] sum) {
        if(root == null) return true;
        boolean left = dfs(root.left, sum);
        boolean right = dfs(root.right, sum);
        if(!left || !right) return false;
        if((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
            sum[0]++;
            return true;
        }
        return false;
    }
}
