public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty() || root != null) {
            if(root == null) {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
            else {
                stack.push(root);
                root = root.left;
            }
        }
        return result;
    }
}
