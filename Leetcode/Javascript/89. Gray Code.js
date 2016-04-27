/*
    Recursion
*/
var grayCode = function(n) {
    if(!n) return [0];
    var last = grayCode(n-1);
    var result = [];
    for(var i = 0; i < last.length; ++i) {
        result.push(last[i]);
    }
    for(i = last.length-1; i >= 0; --i) {
        var tmp = last[i] | (1 << (n-1));
        result.push(tmp);
    }
    return result;
};
/*
    Pure math
*/
var grayCode = function(n) {
    if(!n) return[0];
    var size = 1 << n;
    var result = [];
    for(var i = 0; i < size; ++i) {
        result.push((i >> 1)^i);
    }
    return result;
};
