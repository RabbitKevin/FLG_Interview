public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode p = root;
        while(p != null) {
            TreeLinkNode nextP = p.left;
            TreeLinkNode c = nextP;
            while(c != null) {
                if(p.left == c) {
                    c.next = p.right;
                } else {
                    if(p.next == null) {
                        c.next = null;
                    }
                    else {
                        c.next = p.next.left;
                    }
                    p = p.next;
                }
                c = c.next;
            }
            p = nextP;
        }
    }
}
