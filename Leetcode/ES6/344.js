/*
    For performance
*/
var reverseString = function(s) {
    let array = [];
    for(let i = s.length-1; i >= 0; --i) {
        array.push(s.charAt(i));
    }
    return array.join('');
};

/*
    API
*/
var reverseString = function(s) {
    return s.split('').reverse().join('');
};
