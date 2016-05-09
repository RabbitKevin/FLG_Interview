public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;;
        if(root.left == null && root.right == null) return root.val == sum;
        boolean left = root.left == null?false:hasPathSum(root.left, sum-root.val);
        if(left) return true;
        boolean right = root.right == null?false:hasPathSum(root.right, sum-root.val);
        if(right) return true;
        return false;
    }
}
