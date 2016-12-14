var search = function(nums, target) {
    return help(nums, target, 0, nums.length-1);
};

function help(nums, target, start, end) {
    if(start > end) return false;
    else if(start === end) return nums[start] === target;
    else {
        let mid = start+((end-start) >> 1);
        if(nums[mid] === target) return true;
        if(nums[mid] === nums[start]) return help(nums, target, start, mid-1) || help(nums, target, mid+1, end);
        else if(nums[mid] > nums[start]) {
            if(target >= nums[start] && target < nums[mid]) return help(nums, target, start, mid-1);
            else return help(nums, target, mid+1, end);
        }
        else {
            if(target > nums[mid] && target <= nums[end]) return help(nums, target, mid+1, end);
            else return help(nums, target, start, mid-1);
        }
    }
}
