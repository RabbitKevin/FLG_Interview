var sortTransformedArray = function(nums, a, b, c) {
    let res = new Array(nums.length);
    let left = 0;
    let right = nums.length-1;
    let direction = true;
    let index = 0;
    if(a > 0) {
        direction = false;
        index = nums.length-1;
    }
    let vals = [];
    nums.forEach((num)=> {
        vals.push(a*num*num+b*num+c);
    });
    while(left <= right) {
        if(direction) {
            if(vals[left] <= vals[right]) {
                res[index] = vals[left++];
            }
            else res[index] = vals[right--];
        }
        else {
            if(vals[left] >= vals[right]) {
                res[index] = vals[left++];
            }
            else res[index] = vals[right--];
        }
        index = direction?index+1:index-1;
    }
    return res;
};
