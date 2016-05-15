public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helpMerge(lists, 0, lists.length-1);
    }

    private ListNode helpMerge(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];
        int mid = ((right-left) >> 1)+left;
        ListNode leftList = helpMerge(lists, left, mid);
        ListNode rightList = helpMerge(lists, mid+1, right);
        return merge(leftList, rightList);
    }
    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(one != null && two != null) {
            if(one.val <= two.val) {
                ptr.next = one;
                one = one.next;
            }
            else {
                ptr.next = two;
                two = two.next;
            }
            ptr = ptr.next;
        }
        if(one != null) {
            ptr.next = one;
        }
        if(two != null) {
            ptr.next = two;
        }
        ptr = dummy.next;
        dummy.next = null;
        return ptr;
    }
}

/*
    PQ做法
*/
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val-b.val;
            }
        });
        //--------------------------------------//
        for(ListNode node : lists) {
            if(node != null) pq.add(node);
        }
        //-------------------------------------//
        ListNode result = new ListNode(-1);
        ListNode ptr = result;
        while(!pq.isEmpty()) {
            ListNode cur = pq.poll();
            ptr.next = cur;
            cur = cur.next;
            ptr = ptr.next;
            if(cur != null) pq.add(cur);
        }
        return result.next;
    }
}
