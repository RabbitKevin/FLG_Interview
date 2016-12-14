var twoSum = function(nums, target) {
    let map = new Map();
    let size = nums.length;
    for(let i = 0; i < size; ++i) {
        let tmp = target-nums[i];
        if(map.has(tmp)) return [map.get(tmp), i];
        else map.set(nums[i], i);
    }
    return [-1,-1];
};
