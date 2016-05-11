/*
    但是这个解法有个问题，share code. 按理说不该share的..............
*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return helpFuc(1, n);
    }
    private List<TreeNode> helpFuc(int left, int right){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(left > right){
            result.add(null);
            return result;
        }
        for(int i = left; i <= right; ++i){
            List<TreeNode> leftTree = helpFuc(left, i-1);
            List<TreeNode> rightTree = helpFuc(i+1, right);
            for(TreeNode small : leftTree){
                for(TreeNode large : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = small;
                    root.right = large;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
