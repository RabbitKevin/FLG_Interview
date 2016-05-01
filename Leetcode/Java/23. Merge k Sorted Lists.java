/*
    D&C solution
*/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divide(lists, 0, lists.length-1);
    }
    private ListNode divide(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];
        int mid = left+(right-left)/2;
        ListNode one = divide(lists, left, mid);
        ListNode two = divide(lists, mid+1, right);
        return merge(one, two);
    }
    private ListNode merge(ListNode x, ListNode y) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(x != null && y != null) {
            if(x.val <= y.val) {
                head.next = x;
                x = x.next;
            }
            else {
                head.next = y;
                y = y.next;
            }
            head = head.next;
        }
        if(x == null && y == null) head.next = null;
        if(y != null) head.next = y;
        if(x != null) head.next = x;
        head = dummy.next;
        dummy.next = null;
        return head;
    }
}
