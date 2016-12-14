var singleNumber = function(nums) {
    let i = 0;
    nums.forEach((num)=>{
        i = i^num;
    });
    return i;
};
