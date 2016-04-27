/*
    Recursion
*/
var connect = function(root) {
    if(!root) return;
    var p = root.next;
    if(root.right && p) root.right.next = p.left;
    if(root.left) root.left.next = root.right;
    connect(root.right);
    connect(root.left);
};
/*
    Iteration
*/
var connect = function(root) {
    var ptr = root;
    while(ptr) {
        var nextPtr = ptr.left;//beginning point of next layer
        var child = nextPtr;
        while(child) {
            if(child == ptr.left) child.next = ptr.right;
            else {
                ptr = ptr.next;
                if(ptr) child.next = ptr.left;
            }
            child = child.next;
        }
        ptr = nextPtr;
    }
};
