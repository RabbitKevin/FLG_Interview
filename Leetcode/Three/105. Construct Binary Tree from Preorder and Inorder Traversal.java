public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return help(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }

    private TreeNode help(int[] pre, int p_start, int p_end, int[] in, int i_start, int i_end, Map<Integer, Integer> map) {
        if(p_start > p_end || i_start > i_end) return null;
        if(p_start == p_end) return new TreeNode(pre[p_start]);
        int candidate = pre[p_start];
        int index = map.get(candidate);
        TreeNode root = new TreeNode(in[index]);
        //-------------------------------------//
        int rightSize = i_end-index;
        TreeNode left = help(pre, p_start+1, p_end-rightSize, in, i_start, index-1, map);
        TreeNode right = help(pre, p_end-rightSize+1, p_end, in, index+1, i_end, map);
        root.left = left;
        root.right = right;
        return root;
    }
}
