public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root != null) dfs(root, result, "");
        return result;
    }
    private void dfs(TreeNode root, List<String> result, String path) {
        if(root.left == null && root.right == null) {
            result.add(path+root.val);
            return;
        }
        path = path+String.valueOf(root.val)+"->";
        if(root.left != null) dfs(root.left, result, path);
        if(root.right != null) dfs(root.right, result, path);
    }
}
