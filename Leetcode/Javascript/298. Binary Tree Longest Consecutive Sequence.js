/*
  自己写的DFS, 维护一个传入的[max].
*/
var longestConsecutive = function(root) {
    var max = [0];
    help(root, max);
    return max[0];
};
function help(root, max) {
    if(!root) return 0;
    var left = 1;
    var tmp = help(root.left, max);
    if(root.left && root.left.val-root.val === 1) left = tmp+1;
    var right = 1;
    tmp = help(root.right, max);
    if(root.right && root.right.val-root.val === 1) right = tmp+1;
    max[0] = Math.max(Math.max(left, right), max[0]);
    return Math.max(left, right);
}
//感觉代码不够简洁
/*
  Dis里看到的一个比较简洁的写法，将path 作为变量传入
  把我的写法里两次左右子树的判断放到递归前面了～～～～2
*/
var longestConsecutive = function(root) {
    if(!root) return 0;
    var max = [0];
    help(root, 0, root.val, max);
    return max[0];
};
function help(root, cur, target, max) {
    if(!root) return;
    if(root.val === target) cur++;
    else cur = 1;
    max[0] = Math.max(max[0], cur);
    target = root.val+1;
    help(root.left, cur, target, max);
    help(root.right, cur, target, max);
}
