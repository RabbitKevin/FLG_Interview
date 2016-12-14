var countPrimes = function(n) {
    let map = new Array(n).fill(false);
    for(let i = 2; i < Math.sqrt(n); ++i) {
        if(map[i]) continue;
        else {
            for(let j = i*i; j < n; j+=i) {
                map[j] = true;
            }
        }
    }
    //-------------------------------------//
    let count = 0;
    for(let i = 2; i < n; ++i) {
        if(!map[i]) count++;
    }
    return count;
};
