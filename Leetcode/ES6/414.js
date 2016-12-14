var thirdMax = function(nums) {
    let first = Number.NEGATIVE_INFINITY;
    let second = Number.NEGATIVE_INFINITY;
    let third = Number.NEGATIVE_INFINITY;
    let dic = {};
    nums.forEach(function(num) {
        if(dic.hasOwnProperty(num)) return;
        else if(num >= first) {
            third = second;
            second = first;
            first = num;
        }
        else if(num >= second) {
            third = second;
            second = num;
        }
        else if( num >= third) {
            third = num;
        }
        dic[num] = true;
    });
    return third === Number.NEGATIVE_INFINITY?first:third;
};
