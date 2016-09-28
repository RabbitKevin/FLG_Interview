public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return help(root, root.left)+help(root, root.right);
    }
    private int help(TreeNode parent, TreeNode child) {
        if(child == null) return 0;
        if(child.left == null && child.right == null && child == parent.left) return child.val;
        return help(child, child.left)+help(child, child.right);
    }
}
