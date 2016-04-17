var hasCycle = function(head) {
    var fast = head;
    var slow = head;
    while(fast) {
        fast = fast.next;
        slow = slow.next;
        if(fast) fast = fast.next;
        else break;
        if(fast === slow) return true;
    }
    return false;
};
