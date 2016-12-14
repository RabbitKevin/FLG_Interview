var hasCycle = function(head) {
    if(!head || !head.next) return false;
    let ptr_1 = head;
    let ptr_2 = head.next.next;
    while(ptr_2 && ptr_1 !== ptr_2) {
        ptr_1 = ptr_1.next;
        ptr_2 = ptr_2.next;
        if(ptr_2) ptr_2 = ptr_2.next;
    }
    return ptr_2 !== null;
};
