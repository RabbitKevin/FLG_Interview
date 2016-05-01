/*
    第一遍做的解法
    D&C时候需要额外的信息，所以写个help function, 返回一个TreeNode[]
*/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = dfs(root, p, q);
        return result[0];
    }
    private TreeNode[] dfs(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] result = new TreeNode[3];
        if(root == null) return result;
        TreeNode[] left = dfs(root.left, p, q);
        if(left[0] != null) return left;
        TreeNode[] right = dfs(root.right, p, q);
        if(right[0] != null) return right;
        //--------------------------------------//
        if(root == p || left[1] == p || right[1] == p) result[1] = p;
        if(root == q || left[2] == q || right[2] == q) result[2] = q;
        if(result[1] == p && result[2] == q) result[0] = root;
        return result;
    }
}
/*
    参考写法, 略去了多余的返回信息
*/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //---------------------//
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else if(right != null) return right;
        return null;
    }
}
