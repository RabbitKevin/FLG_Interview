var minMoves2 = function(nums) {
    nums.sort((a,b) => a-b);
    let index = nums.length >> 1;
    let count = 0;
    let mid = nums[index];
    for(let num of nums) {
        count += num > mid?num-mid:mid-num;
    }
    return count;
};
