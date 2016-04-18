/*
  DP解法
*/
var maxSubArray = function(nums) {
    if(!nums.length) return 0;
    var sum = 0;
    var max = Number.NEGATIVE_INFINITY;
    nums.forEach(function(num) {
        sum = sum > 0?sum+num:num;
        max = Math.max(sum, max);
    });
    return max;
};
/*
  D&C解法
*/
var maxSubArray = function(nums) {
    if(!nums.length) return 0;
    return help(nums, 0, nums.length-1);
};
function help(nums, left, right) {
    if(left > right) return Number.NEGATIVE_INFINITY;
    var mid = (left+right) >> 1;
    var left_sub = help(nums, left, mid-1);
    var right_sub = help(nums, mid+1, right);
    //--------------------------------------//
    var sub_max = nums[mid];
    var sub_sum = sub_max;
    for(var i = mid+1; i <= right; ++i) {
        sub_sum+=nums[i];
        sub_max = Math.max(sub_sum, sub_max);
    }
    sub_sum = sub_max;
    for(i = mid-1; i >= left; --i) {
        sub_sum+=nums[i];
        sub_max = Math.max(sub_sum, sub_max);
    }
    return Math.max(sub_max, Math.max(left_sub, right_sub));
}
