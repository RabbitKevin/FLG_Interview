var combinationSum3 = function(k, n) {
    var result = [];
    if(n <= 0 || !k) return result;
    dfs(1, n, k, [], result);
    return result;
};
function dfs(num, remain, count, list, result) {
    if(!remain) {
        if(!count) result.push(list.slice());
        return;
    }
    if(num > remain || num > 9) return;
    for(var i = num; i <= 9; ++i) {
        list.push(i);
        dfs(i+1, remain-i, count-1, list, result);
        list.pop();
    }
}
