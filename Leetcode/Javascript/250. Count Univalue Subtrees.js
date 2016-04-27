/*
    返回一个array, 同时包括包含当前点，和不包含
*/
var countUnivalSubtrees = function(root) {
    if(!root) return 0;
    var count = dfs(root);
    return count[1]+count[0];
};
function dfs(node) {
    if(!node.left && !node.right) return [1,0];
    var count = [0,0];//include/exclude
    var left = node.left?dfs(node.left):[0,0];
    var right = node.right?dfs(node.right):[0,0];
    count[1] = left[0]+left[1]+right[0]+right[1];
    if(node.left && node.right) {
        if(left[0] && right[0] && node.val === node.left.val && node.val === node.right.val) count[0] = 1;
    }
    else if(node.left) {
        if(left[0] && node.val === node.left.val) count[0] = 1;
    }
    else {
        if(right[0] && node.val === node.right.val) count[0] = 1;
    }
    return count;
}
