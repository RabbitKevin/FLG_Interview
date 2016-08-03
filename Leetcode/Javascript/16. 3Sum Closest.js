var threeSumClosest = function(nums, target) {
    nums.sort(function(a,b) {
        return a-b;
    });
    //---------------------//
    var candidate = Number.POSITIVE_INFINITY;
    for(var i = 0; i < nums.length-2; ++i) {
        var left = i+1;
        var right = nums.length-1;
        while(left < right) {
            var sum = nums[i]+nums[left]+nums[right];
            if(sum == target) return sum;
            if(Math.abs(sum-target) < Math.abs(candidate-target)) candidate = sum;
            else {
                if(sum < target) left++;
                else right--;
            }
        }
        while(i < nums.length && nums[i+1] == nums[i]) ++i;
    }
    return candidate;
};
