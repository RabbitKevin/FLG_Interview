/*
    Tree selection
*/
var maxDepth = function(root) {
    if(!root) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
};

/*
    DFS search
*/
var maxDepth = function(root) {
    let stack  = [];
    if(!root) return 0;
    root.depth = 1;
    stack.push(root);
    let max = 0;
    //--------------------//
    while(stack.length) {
        let cur = stack.pop();
        if(!cur.left && !cur.right) max = Math.max(max, cur.depth);
        if(cur.right) {
            cur.right.depth  =cur.depth+1;
            stack.push(cur.right);
        }
        if(cur.left) {
            cur.left.depth  =cur.depth+1;
            stack.push(cur.left);
        }
    }
    return max;
};
