/*
    类似于bucket sort
    但是因为所有数都是正的，所以标记用负数
*/
var findDuplicates = function(nums) {
    let res = [];
    nums.forEach((num, index) => {
        if(!num || num === -1) return;
        while(num && num != -1) {
            if(num == index+1) {
                nums[index] = 0;
                break;
            }
            let next = nums[num-1];
            if(!next) {
                res.push(num);
                nums[index] = -1;
                return;
            }
            else {
                nums[num-1] = 0;
                nums[index] = next;
                num = next;
            }
        }
    })
    return res;
};
