/*
    Reservoir Sampling
    Interesting
*/
public class Solution {
    private ListNode head;
    private Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode ptr = head;
        int val = head.val;
        for(int i =1; ptr != null; i++, ptr = ptr.next) {
            if(random.nextInt(i) == 0) val = ptr.val;
        }
        return val;
    }
}
