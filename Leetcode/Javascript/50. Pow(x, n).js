var myPow = function(x, n) {
    if(n < 0) return 1/help(x, Math.abs(n));
    else return help(x, n);
};

var help = function(x, n) {
    if(!n) return 1;
    if(n === 1) return x;
    var val = myPow(x, Math.floor(n/2));
    if((n&1)) return val*val*x;
    else return val*val;
}
