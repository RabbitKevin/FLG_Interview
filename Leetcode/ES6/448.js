var findDisappearedNumbers = function(nums) {
    for(let i = 0; i < nums.length; ++i) {
        let val = nums[i];
        if(val > 0) {
            nums[i] = 0;//empty
            while(val > 0) {
                let next = nums[val-1];
                if(next >= 0) {
                    nums[val-1] = -1;
                }
                val = next;
            }
        }
    }
    let res = [];
    nums.forEach((num, index) =>{
        if(!num) res.push(index+1);
    });
    return res;
};
