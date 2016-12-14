var isPalindrome = function(head) {
    if(!head) return true;
    let reverse = (node)=>{
        let tail = null;
        let ptr = node;
        while(ptr) {
            let next = ptr.next;
            ptr.next = tail;
            tail =ptr;
            ptr = next;
        }
        return tail;
    }
    //-----------------------------//
    let first = head,
        second = head;
    while(first.next && first.next.next) {
        first = first.next.next;
        second = second.next;
    }
    //-----------------------------------//
    let tmp = second.next;
    second.next = null;
    let reverseList = reverse(tmp);
    first = head;
    while(first && reverseList) {
        if(reverseList.val !== first.val) return false;
        first = first.next;
        reverseList = reverseList.next;
    }
    return true;
};
