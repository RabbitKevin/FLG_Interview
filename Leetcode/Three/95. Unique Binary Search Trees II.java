public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        if(n == 0) return result[0];
        result[0].add(null);
        //-------------------------------------//
        for(int i = 1; i <= n; ++i) {
            result[i] = new ArrayList<TreeNode>();
            for(int j = 1; j <= i; ++j) {
                for(TreeNode leftSub : result[j-1]) {
                    for(TreeNode rightSub : result[i-j]) {
                        //TreeNode left = cloneTree(leftSub, 0);
                        TreeNode root = new TreeNode(j);
                        TreeNode right = cloneTree(rightSub, j);
                        root.left = leftSub;
                        root.right = right;
                        result[i].add(root);
                    }
                }
            }
        }
        return result[n];
    }
    private TreeNode cloneTree(TreeNode root, int offset) {
        if(root == null) return null;
        TreeNode copy = new TreeNode(root.val+offset);
        TreeNode left = cloneTree(root.left, offset);
        TreeNode right = cloneTree(root.right, offset);
        copy.left = left;
        copy.right = right;
        return copy;
    }
}
