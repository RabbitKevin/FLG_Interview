/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

 /*
    非递归版本
    实现题，其实就是沿着上一层的node平移，一直寻找下一个可以被链接的点.
    注意下一层的起始点一开始是空的
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode ptr = root;
        while(ptr != null) {
            //---Find the next child point
            boolean toLeft = true;//next child direction
            TreeLinkNode node = null;//child
            TreeLinkNode nextPtr = null;//next parent node
            TreeLinkNode sub = null;
            while(ptr != null) {//未走到末尾
                while(node == null && ptr != null) {//寻找下一个被连接的node
                    if(toLeft) node = ptr.left;//如果下一个candidate是left child
                    else {//right child
                        node = ptr.right;
                        ptr = ptr.next;
                    }
                    toLeft = !toLeft;
                    //-------------//
                }
                if(nextPtr == null) {//start point of next layer
                    nextPtr = node;
                    sub = nextPtr;
                }
                else {//下一个被连接的点
                    sub.next = node;
                    sub = node;
                }
                node = null;
            }
            ptr = nextPtr;//下一层开始
            nextPtr = null;
        }
    }
}

/*
    递归版本
    Top-down
    connect before deeper recursion
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode p = root.next;
        //find the right
        while(p != null) {
            if(p.left != null) {
                p = p.left;
                break;
            }
            if(p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }
        //------------//
        if(root.right != null) {
            root.right.next = p;
        }
        if(root.left != null) {
            root.left.next = root.right == null?p:root.right;
        }
        connect(root.right);
        connect(root.left);
}
