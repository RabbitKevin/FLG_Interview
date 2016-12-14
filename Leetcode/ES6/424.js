var characterReplacement = function(s, k) {
    if(k >= s.length-1) return s.length;
    //----------------------------------//
    let dic = [];
    for(let i = 0; i < 26; ++i) {
        dic.push(0);
    }
    //---------------------------------//
    let left = 0;
    let max = 0;
    let res = 0;
    for(let i = 0; i < s.length; ++i) {
        let index = s.charCodeAt(i)-65;
        dic[index]++;
        max = Math.max(max, dic[index]);
        while(i+1-left-max > k) {
            let key = s.charCodeAt(left)-65;
            dic[key]--;
            left++;
        }
        res = Math.max(res, i-left+1);
    }
    return res;
};
