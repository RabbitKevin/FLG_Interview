/*
    Determine whether one tree is a subtree of another tree
    The subtree here is not a part of another tree, it may be the copy of part of that.
    Can not just compare the TreeNode variable
*/
class Solution {
    public static void main(String[] args) {

    }
    public static boolean isSubTree(TreeNode root, TreeNode node) {
        if(node == null) return true;
        if(root == null) return false;
        if(isIdentical(root, node)) return true;
        return isSubTree(root.left, node) || isSubTree(root.right, node);
    }
    private static boolean isIdentical(TreeNode root, TreeNode node) {
        if(root == null && node == null) return true;
        if(root == null || node == null) return false;
        return root.val == node.val && isIdentical(root.left, node.left) && isIdentical(root.right, node.right)；
    }
}

/*
    http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
    O(n)的解法，需要添加special case处理null节点，不然无法处理copy的tree
*/
