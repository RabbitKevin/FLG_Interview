public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        //----------------------------//
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode ptr = root;
        while(ptr.right != null) {
            ptr = ptr.right;
        }
        ptr.right = right;
    }
}
