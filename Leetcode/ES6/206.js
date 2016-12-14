var reverseList = function(head) {
    let tail = null;
    let ptr = head;
    while(ptr) {
        let next = ptr.next;
        ptr.next = tail;
        tail = ptr;
        ptr = next;
    }
    return tail;
};
