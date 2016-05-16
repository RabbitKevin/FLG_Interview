public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        //------------------------------------//
        //ListNode start = head;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode root = slow.next;
        slow.next = null;
        ListNode right = root.next;
        root.next = null;
        TreeNode result = new TreeNode(root.val);
        TreeNode leftSub = sortedListToBST(head);
        TreeNode rightSub = sortedListToBST(right);
        result.left = leftSub;
        result.right = rightSub;
        return result;
    }
}
