public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return help(nums, 0, nums.length-1);
    }
    private TreeNode help(int[] num, int start, int end) {
        if(start > end) return null;
        int mid = start+((end-start) >> 1);
        TreeNode left = help(num, start, mid-1);
        TreeNode right = help(num, mid+1, end);
        TreeNode root = new TreeNode(num[mid]);
        root.left = left;
        root.right = right;
        return root;
    }
}

/*
    https://leetcode.com/discuss/36616/java-iterative-solution
*/
