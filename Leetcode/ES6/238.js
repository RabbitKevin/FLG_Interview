var productExceptSelf = function(nums) {
    let output = new Array(nums.length);
    let left = 1;
    nums.forEach((num, index)=>{
        output[index] = left;
        left*=num;
    });
    let right = 1;
    for(let i = nums.length-1; i >= 0; --i) {
        output[i] = right*output[i];
        right*=nums[i];
    }
    return output;
};
