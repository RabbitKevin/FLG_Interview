/*
  如果数比最小的还小，0;
  如果比最大的还大，nums.length;
  如果是在内部插入，那么就是寻找第一个不小于它的数的index.
  逼近右侧
*/
var searchInsert = function(nums, target) {
    var left = 0;
    var right = nums.length-1;
    if(target < nums[0]) return 0;
    if(target > nums[nums.length-1]) return nums.length;
    while(left < right) {
        var mid = (left+right) >> 1;
        if(nums[mid] === target) return mid;
        if(nums[mid] < target) left = mid+1;//如果mid点小于target, mid点绝对不可能成为插入点
        else right = mid;//如果说mid点大于target, mid依然有可能成为插入点
    }
    return right;
};
