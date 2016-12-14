/*

*/
var findAnagrams = function(s, p) {
    let caseArr = [];
    for(let i = 0; i < 26; ++i) {
        caseArr.push(0);
    }
    //--------------------------//
    for(let i = 0; i < p.length; ++i) {
        let index = p.charCodeAt(i)-97;
        caseArr[index]++;
    }
    //----------------------------------//
    let offset = p.length;
    let count = p.length;
    let res = [];
    for(let i = 0; i < s.length; ++i) {
        let index = s.charCodeAt(i)-97;
        if(caseArr[index] >= 1) count--;
        caseArr[index]--;
        if(i >= offset) {
            let endIndex = s.charCodeAt(i-offset)-97;
            if(caseArr[endIndex] >= 0) count++;
            caseArr[endIndex]++;
        }
        if(!count) res.push(i-offset+1);
    }
    return res;
};

/*
    11.29
*/
var findAnagrams = function(s, p) {
    if(s.length < p.length) return [];
    let res = [];
    let map = new Array(26).fill(0);
    //-----------------------------//
    for(let i = 0; i < p.length; ++i) {
        let index = p.charCodeAt(i)-97;
        map[index]++;
    }
    //-----------------------------//
    let left = 0;
    let right = 0;
    let count = p.length;
    while(right < s.length) {
        let index = s.charCodeAt(right)-97;
        if(map[index] > 0) count--;
        map[index]--;
        right++;
        //--------------------------------//
        if(!count) res.push(left);
        let leftIndex = s.charCodeAt(left)-97;
        if(right-left === p.length) {
            if(map[leftIndex] >= 0) count++;
            map[leftIndex]++;
            left++;
        }
    }
    return res;
};
