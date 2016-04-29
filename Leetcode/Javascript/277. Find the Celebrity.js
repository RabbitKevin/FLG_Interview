/*
    减少不必要的query.
    绝对不必要的query发生在，两个人都是被否决的情况下
*/
var solution = function(knows) {
    /**
     * @param {integer} n Total people
     * @return {integer} The celebrity
     */
    return function(n) {
        var map = [];
        for(var i = 0; i < n; ++i) { map[i] = false;}
        //------------------------------------------//
        for(i = 0; i < n; ++i) {
            for(var j = 0; j < n;++j) {
                if(i === j) continue;
                if(map[i] && map[j]) continue;
                if(knows(j,i)) {
                    map[j] = true;
                }
                else {
                    map[i] = true;
                }
            }
        }
        for(i = 0; i < n; ++i) {
            if(!map[i]) return i;
        }
        return -1;
    };
};
