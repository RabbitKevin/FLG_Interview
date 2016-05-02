/*
    注意random指向空指针的情况
*/
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //----add node behind ----//
        RandomListNode ptr = head;
        if(ptr == null) return null;
        while(ptr != null) {
            RandomListNode next = ptr.next;
            ptr.next = new RandomListNode(ptr.label);
            ptr.next.next = next;
            ptr = next;
        }
        //----add random----//
        ptr = head;
        while(ptr != null) {
            ptr.next.random = (ptr.random == null)?null:ptr.random.next;
            ptr = ptr.next.next;
        }
        //----break--------//
        ptr = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode start = dummy;
        while(ptr != null) {
            RandomListNode copy = ptr.next;
            ptr.next = copy.next;
            start.next = copy;
            start = start.next;
            ptr = ptr.next;
        }
        start.next = null;
        return dummy.next;
    }
}
