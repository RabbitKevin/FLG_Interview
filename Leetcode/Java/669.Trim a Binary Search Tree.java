class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        int val = root.val;
        if(val < L) return trimBST(root.right, L, R);
        else if(val > R) return trimBST(root.left, L, R);
        else {
            root.left = trimBST(root.left, L, val-1);
            root.right = trimBST(root.right, val+1, R);
            return root;
        }
    }
}
