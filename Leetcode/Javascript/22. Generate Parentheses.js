/*
  Backtacking
*/
var generateParenthesis = function(n) {
    var result = [];
    help(result, [], n, n, (n << 1));
    return result;
};

function help(result, stack, left, right, size) {
    if(!size) {
        result.push(stack.join(''));
        return;
    }
    if(left) {
        stack.push('(');
        help(result, stack, left-1, right, size-1);
        stack.pop();
    }
    if(left < right) {
        stack.push(')');
        help(result, stack, left, right-1, size-1);
        stack.pop();
    }
}
