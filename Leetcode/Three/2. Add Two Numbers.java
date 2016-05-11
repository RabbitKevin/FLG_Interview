public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode ptr = dummy;
        int c = 0;
        while(p1 != null && p2 != null) {
            int sum = c+p1.val+p2.val;
            if(sum >= 10) {
                c = 1;
                sum-=10;
            }
            else c = 0;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 != null || p2 != null) {
            p1 = p1 != null?p1:p2;
            while(p1 != null) {
                int sum = p1.val+c;
                if(sum == 10) {
                    c = 1;
                    sum = 0;
                }
                else c = 0;
                ptr.next = new ListNode(sum);
                ptr = ptr.next;
                p1 = p1.next;
            }
        }
        if(c != 0) ptr.next = new ListNode(1);
        return dummy.next;
    }
}
