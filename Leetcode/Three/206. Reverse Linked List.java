public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode trail = head;
        head = head.next;
        trail.next = null;
        while(head != null) {
            ListNode node = head;
            head = head.next;
            node.next = trail;
            trail = node;
        }
        return trail;
    }
}
