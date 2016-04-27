var permute = function(nums) {
    var result = [];
    var visited = [];
    for(var i = 0; i < nums.length; ++i) visited.push(false);
    dfs(nums, [], result, nums.length, visited);
    return result;
};
function dfs(nums, line, result, n, visited) {
    if(!n) {
        result.push(line.slice());
        return;
    }
    for(var i = 0; i < nums.length; ++i) {
        if(visited[i]) continue;
        visited[i] = true;
        line.push(nums[i]);
        dfs(nums, line, result, n-1, visited);
        line.pop();
        visited[i] = false;
    }
}
