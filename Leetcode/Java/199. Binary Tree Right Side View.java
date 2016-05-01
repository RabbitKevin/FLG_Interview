/*
    BFS version
*/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        queue.add(root);
        while(!queue.isEmpty()) {
            result.add(queue.peek().val);
            Queue<TreeNode> next = new LinkedList<>();
            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if(cur.right != null) next.add(cur.right);
                if(cur.left != null) next.add(cur.left);
            }
            queue = next;
        }
        return result;
    }
}
/*
    DFS version
    维护一个已有最大depth max
    当前depth == max, result.add(node.val);
*/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int[] max = new int[]{0};
        dfs(root, result, max, 0);
        return result;
    }
    private void dfs(TreeNode root, List<Integer> result, int[] max, int depth) {
        if(root == null) return;
        if(depth == max[0]) {
            result.add(root.val);
            max[0]++;
        }
        dfs(root.right, result, max,depth+1);
        dfs(root.left, result, max, depth+1);
    }
}
