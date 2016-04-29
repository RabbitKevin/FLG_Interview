/*
    DFS
*/
var subsets = function(nums) {
    var result = [];
    if(!nums.length) return result;
    nums.sort(function(a,b) {
        return a-b;
    });
    //-----------------------//
    dfs(0, nums, [], result);
    return result;
};
function dfs(i, nums, list, result) {
    if(i === nums.length) {
        result.push(list.slice());
        return;
    }
    dfs(i+1, nums, list, result);
    list.push(nums[i]);
    dfs(i+1, nums, list, result);
    list.pop();
}

/*
    Bitwise operation
    总共2^n种可能
*/
var subsets = function(nums) {
    var result = [];
    if(!nums.length) return result;
    nums.sort(function(a,b) {
        return a-b;
    });
    var size = (1 << (nums.length));
    for(var i = 0; i < size; ++i) {
        var list = [];
        var tmp = i;
        var index = 0;
        while(tmp) {
            if((tmp & 1)) list.push(nums[index]);
            index++;
            tmp = tmp >> 1;
        }
        result.push(list);
    }
    return result;
};
