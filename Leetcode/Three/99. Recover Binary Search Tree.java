/*
    比较暴力的做法， 直接inorder traversal
*/
public class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        dfs(root, vals, list);
        Collections.sort(vals);
        for(int i = 0; i < list.size(); ++i) {
            list.get(i).val = vals.get(i);
        }
    }
    private void dfs(TreeNode root, List<Integer> vals, List<TreeNode> list) {
        if(root == null) return;
        dfs(root.left, vals, list);
        vals.add(root.val);
        list.add(root);
        dfs(root.right, vals, list);
    }
}

/*
    Smart idea
*/
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3];//pre 1st 2nd
        dfs(root, nodes);
        swap(nodes[1], nodes[2]);
    }

    private void dfs(TreeNode root, TreeNode[] nodes) {
        if(root == null) return ;
        dfs(root.left, nodes);
        if(nodes[0] != null && root.val < nodes[0].val) {
            if(nodes[1] == null) nodes[1] = nodes[0];
            nodes[2] = root;
        }
        nodes[0] = root;
        dfs(root.right, nodes);
    }
    private void swap(TreeNode one, TreeNode two) {
        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }
}
