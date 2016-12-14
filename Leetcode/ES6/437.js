var pathSum = function(root, sum) {
    if(!root) return 0;
    let base = dfs(root, sum);
    base+=pathSum(root.left, sum);
    base+=pathSum(root.right, sum);
    return base;
};
function dfs(node, val) {
    if(!node) return 0;
    let res = node.val === val?1:0;
    res+=dfs(node.left, val-node.val);
    res+=dfs(node.right, val-node.val);
    return res;
}
