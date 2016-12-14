var getRow = function(rowIndex) {
    let nums = [1];
    for(let i = 1; i <= rowIndex; ++i) {
        nums.push(1);
        for(let j = nums.length-2; j > 0; --j) {
            nums[j] = nums[j-1]+nums[j];
        }
    }
    return nums;
};
