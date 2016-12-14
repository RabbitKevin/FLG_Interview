var isAnagram = function(s, t) {
    if(s.length != t.length) return false;
    let map = new Array(26).fill(0);
    for(let i = 0; i < s.length; ++i) {
        let index = s.charCodeAt(i)-97;
        map[index]++;
    }
    for(let j = 0; j < t.length; ++j) {
        let index = t.charCodeAt(j)-97;
        if(!map[index]) return false;
        map[index]--;
    }
    return true;
};
