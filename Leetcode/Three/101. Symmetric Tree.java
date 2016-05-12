/*
    Recursion
*/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode x, TreeNode y) {
        if(x == null && y == null) return true;
        if(x == null || y == null || x.val != y.val) return false;
        return isMirror(x.right, y.left) && isMirror(x.left, y.right);
    }
}
