var majorityElement = function(nums) {
    let candidate = nums[0];
    let count = 1;
    let size = nums.length;
    for(let i = 1; i < size; ++i) {
        if(nums[i] === candidate) count++;
        else {
            if(!count) {
                candidate = nums[i];
                count = 1;
            }
            else count--
        }
    }
    return candidate;
};
