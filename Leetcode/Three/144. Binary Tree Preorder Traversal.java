public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            if(node != null) {
                result.add(node.val);
                if(node.right != null) stack.push(node.right);
                node = node.left;
            }
            else {
                node = stack.pop();
            }
        }
        return result;
    }
}
