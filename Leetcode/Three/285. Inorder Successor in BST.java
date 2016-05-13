public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.val < root.val) {
            TreeNode leftCandidate = inorderSuccessor(root.left, p);
            if(leftCandidate != null) return leftCandidate;
            else return root;
        }
        return inorderSuccessor(root.right, p);
    }
}
