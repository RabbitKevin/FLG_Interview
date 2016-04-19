class Solution {
  public static void main(String[] args) {
    //自己构一个简单的图
    int size = 6;
    TreeNode[] nodes = new TreeNode[size];
    for(int i = 0; i < size; ++i) {
      nodes[i] = new TreeNode(i);
    }
    //-----------------------------//
    /*
              1
        2           6
    3
4       5
*/
    nodes[0].left = nodes[1];
    nodes[0].right = nodes[5];
    nodes[1].left = nodes[2];
    nodes[2].left = nodes[3];
    nodes[2].right = nodes[4];
    //-----------------------//
    TreeNode next = PostOrder_Next(nodes[0], nodes[5]);
    System.out.println(next.val);
  }
  /*
    Finding the next point in PostOrder
  */
  public static TreeNode PostOrder_Next(TreeNode root, TreeNode target) {
    if(root == target) {
      TreeNode node =  root;
      while(node.left != null) node = node.left;
      return node;
    }
    TreeNode parent = findParent(root, target);
    if(target == parent.right) return parent;
    else {
      if(parent.right == null) return parent;
      else {
        parent = parent.right;
        while(parent.left != null) parent = parent.left;
      }
      return parent;
    }
  }
  private static TreeNode findParent(TreeNode root, TreeNode target) {
    if(root == null) return null;
    if(root.left == target || root.right == target) return root;
    TreeNode left = findParent(root.left, target);
    TreeNode right = findParent(root.right, target);
    if(left != null) return left;
    if(right != null) return right;
    return null;
  }
}
