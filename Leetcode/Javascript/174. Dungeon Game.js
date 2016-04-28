var calculateMinimumHP = function(dungeon) {
    var m = dungeon.length;
    if(!m) return 1;
    var n = dungeon[0].length;
    var dp = [];
    var row = [];
    for(var i = 0; i < n; ++i) {
        row.push(0);
    }
    for(i = 0; i < m; ++i) {
        dp.push(row.slice());
    }
    //-------------------------------------//
    for(i = m-1; i >= 0; --i) {
        for(var j = n-1; j >= 0; --j) {
            if(i === m-1 && j === n-1) {
                dp[m-1][n-1] = (dungeon[m-1][n-1] >= 0)?1:cal(1-dungeon[m-1][n-1]);
                continue;
            }
            var right = (j === n-1)?Number.POSITIVE_INFINITY:cal(dp[i][j+1]-dungeon[i][j]);
            var down = (i === m-1)?Number.POSITIVE_INFINITY:cal(dp[i+1][j]-dungeon[i][j]);
            dp[i][j] = Math.min(right,down);
        }
    }
    return dp[0][0];
};

function cal(num) {
    if(num < 1) return 1;
    return num;
}
