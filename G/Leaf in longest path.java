class Solution{
    public static void main(String[] args) {

    }
    public static List<TreeNode> findLeafs(TreeNode root) {
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        layer.add(root);
        while(!layer.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<TreeNode>();
            int size = layer.size();
            for(int i = 0; i < size; ++i) {
                TreeNode node = layer.pop();
                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
                layer.add(node);
            }
            if(!next.isEmpty()) layer = next;
        }
        return new ArrayList<TreeNode>(layer);
    }
}
