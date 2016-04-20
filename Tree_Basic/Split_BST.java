class Solution {
    public static void main(String[] args) {
        //自己构一个简单的图
        int size = 8;
        TreeNode[] nodes = new TreeNode[size];
        for(int i = 0; i < size; ++i) {
          nodes[i] = new TreeNode(i);
        }
        //-----------------------------//
        /*
                  4
            2           5
        1       3   6       7
    0
    */
        nodes[4].left = nodes[2];
        nodes[4].right = nodes[6];
        nodes[2].left = nodes[1];
        nodes[2].right = nodes[3];
        nodes[1].left = nodes[0];
        nodes[6].left = nodes[5];
        nodes[6].right = nodes[7];
        //-----------------------//
        TreeNode[] result = dfsSplitBST(nodes[4], 5);
        inorder(result[0]);
        System.out.println();
        inorder(result[1]);
        System.out.println();
    }
    public static TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] twoBST = new TreeNode[2];
        TreeNode curS = null;
        TreeNode curL = null;
        while(root != null) {
          //There exist such a point that equals to target
          if(root.val <= target) {
            //Handling initial state
            if(twoBST[0] == null) twoBST[0] = root;//root of small tree
            if(curS != null) curS.right = root;
            curS = root;
            root = root.right;
          }
          else {
            if(twoBST[1] == null) twoBST[1] = root;
            if(curL != null) curL.left = root;
            curL = root;
            root = root.left;
          }
        }
        if(curS != null) curS.right = null;
        if(curL != null) curL.left = null;
        return twoBST;
    }
    public static TreeNode[] dfsSplitBST(TreeNode root, int target) {
        if(root == null) return new TreeNode[2];
        if(root.val <= target) {//try to find in right-sub tree
            TreeNode right = root.right;
            root.right = null;
            TreeNode[] tmp = dfsSplitBST(right, target);
            root.right = tmp[0];
            tmp[0] = root;
            return tmp;
        }
        else {
            TreeNode left = root.left;
            root.left = null;
            TreeNode[] tmp = dfsSplitBST(left, target);
            root.left = tmp[1];
            tmp[1] = root;
            return tmp;
        }
    }
    private static void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.val+" ");
        inorder(node.right);
    }
}
