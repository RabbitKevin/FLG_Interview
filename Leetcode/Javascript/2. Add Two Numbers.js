var addTwoNumbers = function(l1, l2) {
    var ptr_1 = l1;
    var ptr_2 = l2;
    var dummy = new ListNode(-1);
    var head = dummy;
    var c = 0;
    while(ptr_1 && ptr_2) {
        var sum = ptr_1.val+ptr_2.val+c;
        if(sum >= 10) {
            c = 1;
            sum = sum-10;
        }
        else c = 0;
        head.next = new ListNode(sum);
        ptr_1 = ptr_1.next;
        ptr_2 = ptr_2.next;
        head = head.next;
    }
    var remain = ptr_1 || ptr_2;
    while(remain && c) {
        sum = remain.val+c;
         if(sum === 10) {
            c = 1;
            sum = 0;
         }
         else c = 0;
         head.next = new ListNode(sum);
         remain = remain.next;
         head = head.next;
    }
    if(!c) head.next = remain;
    else head.next = new ListNode(1);
    return dummy.next;
};
