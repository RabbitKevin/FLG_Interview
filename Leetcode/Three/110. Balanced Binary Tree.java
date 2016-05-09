public class Solution {
    public boolean isBalanced(TreeNode root) {
        int result = getDepth(root);
        return result != -1;
    }

    private int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        if(left == -1) return -1;
        int right = getDepth(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right) > 1) return -1;
        return Math.max(left, right)+1;
    }
}
