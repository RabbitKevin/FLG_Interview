/*
    注意优化，不优化的时候，遍历了太多无用解
    注意用Sqrt(n)做上边界的时候，需要考虑将remain整个放入的情况
*/
var getFactors = function(n) {
    var result = [];
    if(n <= 1) return result;
    dfs(2, n, n, [], result);
    return result;
};
function dfs(start, remain, n, list, result) {
    if(remain === 1) {
        result.push(list.slice());
        return;
    }
    if(remain !== n) {
        list.push(remain);
        dfs(remain, 1, n, list, result);
        list.pop();
    }
    for(var i = start; i <= Math.floor(Math.sqrt(remain)); ++i) {
        if((remain % i)) continue;
        list.push(i);
        dfs(i, remain/i, n, list, result);
        list.pop();
    }
}
