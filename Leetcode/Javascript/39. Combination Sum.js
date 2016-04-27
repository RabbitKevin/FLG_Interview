var combinationSum = function(candidates, target) {
    candidates.sort(function(a,b) {
        return a-b;
    });
    var result = [];
    dfs(0, target, candidates, [], result);
    return result;
};
function dfs(index, remain, nums, list, result) {
    if(remain < 0) return;
    if(!remain) result.push(list.slice());
    for(var i = index; i < nums.length; ++i) {
        list.push(nums[i]);
        dfs(i, remain-nums[i], nums, list, result);
        list.pop();
    }
}
