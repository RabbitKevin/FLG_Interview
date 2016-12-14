var canConstruct = function(ransomNote, magazine) {
    let count = [];
    for(let i = 0; i < 256; ++i) {
        count.push(0);
    }
    //---------------------------------------------//
    for(let i = 0;  i < magazine.length; ++i) {
        let index = magazine.charCodeAt(i);
        count[index]++;
    }
    for(let i = 0; i < ransomNote.length; ++i) {
        let index = ransomNote.charCodeAt(i);
        if(!count[index]) return false;
        count[index]--;
    }
    return true;
};
