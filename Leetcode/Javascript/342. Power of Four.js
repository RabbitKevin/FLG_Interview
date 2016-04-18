/*
  Loop
*/
var isPowerOfFour = function(num) {
    if(num <= 0) return false;
    var count = 0;
    while(num && count < 2) {
        var tmp = num & 3;
        count+=tmp;
        num = num >> 2;
    }
    return count === 1;
};
/*
  非Loop
*/
var isPowerOfFour = function(num) {
    return num > 0 && !Boolean(num&(num-1))&& Boolean(num & 0x55555555);
};
