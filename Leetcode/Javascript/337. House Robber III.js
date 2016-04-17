/*
  解法1:传统的DFS+剪枝.
*/
var rob = function(root) {
    if(!root) return 0;
    if('path' in root) return root['path'];
    var left = (root.left)?rob(root.left.left)+rob(root.left.right):0;
    var right = (root.right)?rob(root.right.left)+rob(root.right.right):0;
    var sum = root.val+left+right;
    //---------------------------------------//
    var value = Math.max(sum, rob(root.left)+rob(root.right));
    root['path'] = value;
    return value;
};

/*
  改变DP的定义.
  究其原因，used/not used不确定. 返回值改成[used, not used]
*/
var rob = function(root) {
    var res = help(root);
    return Math.max(res[0], res[1]);
};
/*
    return res[] 0-if used;1-not used;
*/
function help(root) {
    if(!root) return [0,0];
    var left = help(root.left);
    var right = help(root.right);
    //注意当root没用时候，left,right需要考虑是否适用的情况，不要漏~~~
    return [left[1]+right[1]+root.val, Math.max(left[0], left[1])+Math.max(right[0], right[1])];
}
