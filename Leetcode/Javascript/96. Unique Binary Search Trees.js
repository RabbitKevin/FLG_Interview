/*
    从n~m的范围内构成的二分树的数量＝从0～m-n的范围
    所以可以从1维DP
*/
var numTrees = function(n) {
    var dp = [1];
    for(var i = 1; i <= n;++i) {
        var sum = 0;
        var k = i-1;
        for(var j = 0; j <= k; ++j) {
            sum+=dp[j]*dp[k-j];
        }
        dp.push(sum);
    }
    return dp[n];
};