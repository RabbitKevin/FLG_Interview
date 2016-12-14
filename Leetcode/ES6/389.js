var findTheDifference = function(s, t) {
    let res = 0;
    for(let i = 0; i < s.length; ++i) {
        res = res^(s.charCodeAt(i));
    }
    for(let i = 0; i < t.length; ++i) {
        res = res^(t.charCodeAt(i));
    }
    return String.fromCharCode(res);
};
