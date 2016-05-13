/*
    Recursion
*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode right = root.right;
        TreeNode next = root.left;
        root.left = null;
        root.right = null;
        TreeNode result = upsideDownBinaryTree(next);
        next.right = root;
        next.left = right;
        return result;
    }
}

/*
    Iteration
*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode top = root;
        TreeNode right = root.right;
        root = root.left;
        top.left = null;
        top.right = null;
        while(root.left != null) {
            TreeNode nextRoot = root.left;
            TreeNode nextRight = root.right;
            root.right = top;
            root.left = right;
            top = root;
            right = nextRight;
            root = nextRoot;
        }
        root.right = top;
        root.left = right;
        return root;
    }
}
