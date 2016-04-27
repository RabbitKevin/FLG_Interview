/*
    注意corner case
*/
var findMin = function(nums) {
    var left = 0;
    var right = nums.length-1;
    while(left < right) {
        var mid = (right+left) >> 1;
        if(nums[mid] >= nums[left]) {
            if(nums[right] > nums[left]) right = mid-1;
            else left = mid+1;
        }
        else right = mid;
    }
    return nums[left];
};
