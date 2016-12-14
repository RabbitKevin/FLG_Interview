var uniquePaths = function(m, n) {
    let dp = [];
    for(let i = 0; i < 2; ++i) {
        let tmp = [];
        for(let j = 0; j < n; ++j) {
            tmp.push(i);
        }
        dp.push(tmp);
    }
    //----------------------------//
    let cur = 1,
        next = 0;
    for(let i = 1; i < m; ++i) {
        let nextRow = dp[next],
            curRow = dp[cur];
        for(let j = 0; j < n; ++j) {
            let left = j?nextRow[j-1]:0;
            let up = curRow[j];
            nextRow[j] = left+up;
        }
        cur^=1;
        next^=1;
    }
    //console.log(dp);
    return dp[cur][n-1];
};
