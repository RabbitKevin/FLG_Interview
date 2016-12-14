var generateParenthesis = function(n) {
    let arr = [];
    let res = [];
    help(arr, n, n, res);
    return res;
};

function help(stack, left, right, res) {
    if(!left && !right) {
        res.push(stack.join(''));
        return;
    }
    if(!stack.length || left) {
        stack.push('(');
        help(stack, left-1, right, res);
        stack.pop();
    }
    if(left < right) {
        stack.push(')');
        help(stack, left, right-1, res);
        stack.pop();
    }
}
