var firstUniqChar = function(s) {
    let map = new Array(26).fill(0);
    //-----------------------------//
    for(let i = 0; i < s.length; ++i) {
        let index = s.charCodeAt(i)-97;
        map[index]++;
    }
    //--------------------------------
    for(let i = 0; i < s.length; ++i) {
        if(map[s.charCodeAt(i)-97] === 1) return i;
    }
    return -1;
};
