var combinationSum2 = function(candidates, target) {
    candidates.sort(function(a, b) {
        return a-b;
    });
    //-----------------------------//
    var result = [];
    dfs(0, target, candidates, [], result);
    return result;
};
function dfs(index, remain, nums, list, result) {
    if(!remain) {
        result.push(list.slice());
        return;
    }
    if(remain < 0 || index == nums.length) return;
    for(var i = index; i < nums.length; ) {
        list.push(nums[i]);
        dfs(i+1, remain-nums[i], nums, list, result);
        list.pop();
        ++i;
        while(i < nums.length && nums[i] == nums[i-1]) ++i;
    }
}
