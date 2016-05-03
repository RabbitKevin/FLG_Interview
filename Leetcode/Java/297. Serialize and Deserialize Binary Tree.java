/**
    BFS solution
 */
public class Codec {
    List<Integer> nodes = new ArrayList<Integer>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        help(sb, root);
        return sb.toString();
    }
    private void help(StringBuilder sb, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) sb.append('n');
            else sb.append(node.val);
            sb.append('#');
            if(node == null) continue;
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] vals = data.split("#");
        int count = 0;
        TreeNode[] nodes = new TreeNode[vals.length];
        for(int i = 0; i < nodes.length; ++i) {
            if(!vals[i].equals("n")) nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
        }
        for(int i = 0; i < nodes.length; ++i) {
            if(nodes[i] == null) {
                count++;
                continue;
            }
            int tmp = (i-count) << 1;
            int left = tmp+1;
            int right = tmp+2;
            if(left < nodes.length) nodes[i].left = nodes[left];
            if(right < nodes.length) nodes[i].right = nodes[right];
        }
        return nodes[0];
    }
}
