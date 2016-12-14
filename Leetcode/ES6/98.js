var isValidBST = function(root) {
    return help(root, Number.NEGATIVE_INFINITY, Number.POSITIVE_INFINITY);
};

function help(root, min, max) {
    if(!root) return true;
    if(root.val <= min || root.val >= max) return false;
    return help(root.left, min, root.val) && help(root.right, root.val, max);
}
