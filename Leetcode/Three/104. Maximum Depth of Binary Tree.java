/*
    DFS Solution
*/
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = root.left == null?-1:maxDepth(root.left);
        int right = root.right == null?-1:maxDepth(root.right);
        return Math.max(left, right)+1;
    }
}
/*
    BFS
*/
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            layer++;
        }
        return layer;
    }
}
