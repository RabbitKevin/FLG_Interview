public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean inorder = true;
        while(!stack.isEmpty()) {
            Stack<TreeNode> next = new Stack<>();
            List<Integer> level = new ArrayList<>();
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                level.add(node.val);
                if(inorder) {
                    if(node.left != null) next.push(node.left);
                    if(node.right != null) next.push(node.right);
                }
                else {
                    if(node.right != null) next.push(node.right);
                    if(node.left != null) next.push(node.left);
                }
            }
            inorder = !inorder;
            stack = next;
            result.add(level);
        }
        return result;
    }
}
