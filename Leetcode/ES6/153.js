var findMin = function(nums) {
    return help(nums, 0, nums.length-1);
};

function help(nums, start, end) {
    if(start === end) return nums[start];
    let mid = start+((end-start) >> 1);
    if(nums[mid] <= nums[end]) {
        return help(nums, start, mid);
    }
    else {
        return help(nums, mid+1, end);
    }
}
