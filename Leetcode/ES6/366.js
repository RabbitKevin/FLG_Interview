var findLeaves = function(root) {
    let res = [];
    if(!root) return res;
    while(root.left || root.right) {
        let arr = [];
        dfs(root, arr);
        res.push(arr);
    }
    res.push([root.val]);
    return res;
};

function dfs(root, res, last) {
    if(!root) return;
    if(!root.left && !root.right) {
        res.push(root.val);
        if(root == last.left) last.left = null;
        else last.right = null;
    }
    dfs(root.left, res, root);
    dfs(root.right, res, root);
}
