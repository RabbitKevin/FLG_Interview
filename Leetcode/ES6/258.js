var addDigits = function(num) {
    if(!num) return 0;
    let r = num % 9;
    if(r) return r;
    else return 9;
};
