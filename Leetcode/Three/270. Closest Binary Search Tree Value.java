/*
    写法有点啰嗦
*/
public class Solution {
    public int closestValue(TreeNode root, double target) {
        return dfs(root, target, root.val);
    }

    private int dfs(TreeNode root, double target, int last) {
        if(root == null) return last;
        if((double)root.val == target) return root.val;
        if(target < root.val) {
            int left = dfs(root.left, target, root.val);
            if(Math.abs(target-root.val) < Math.abs(target-left)) return root.val;
            return left;
        }
        else {
            int right = dfs(root.right, target, root.val);
            if(Math.abs(target-root.val) < Math.abs(target-right)) return root.val;
            return right;
        }
    }
}

/*
    Concise~~~~~~
*/
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode node = (root.val>target)?root.left:root.right;
        if (node == null) {
            return root.val;
        }
        int value = closestValue(node, target);
        return Math.abs(root.val-target) > Math.abs(value-target)?value:root.val;
    }
}
