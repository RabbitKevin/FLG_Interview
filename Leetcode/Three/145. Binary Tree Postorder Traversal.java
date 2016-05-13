public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode lastNode = null;
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                TreeNode peek = stack.peek();
                if(peek.right != null && lastNode != peek.right) root = peek.right;
                else {
                    result.add(peek.val);
                    lastNode = stack.pop();
                }
            }
        }
        return result;
    }
}
