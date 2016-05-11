public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return help(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    private TreeNode help(int[] in, int i_start, int i_end, int[] post, int p_start, int p_end, Map<Integer, Integer> map) {
        if(i_start > i_end || p_start > p_end) return null;
        if(i_start == i_end) return new TreeNode(in[i_start]);
        TreeNode root = new TreeNode(post[p_end]);
        int index = map.get(post[p_end]);
        int rightLength = i_end-index;
        TreeNode left = help(in, i_start, index-1, post, p_start, p_end-rightLength-1, map);
        TreeNode right = help(in, index+1, i_end, post, p_end-rightLength, p_end-1, map);
        root.left = left;
        root.right = right;
        return root;
    }
}
