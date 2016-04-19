/*
    观察规律. 2，3是唯一两个不可拆分的数，拆分反而会比不拆更小.
    所以任意一个数，都拆成2, 3.
    当没有2时，增加1，拿一个3出来，拆成2个2;
    当有2因子时，提一个2出来，＋1， 变做3;
*/
var integerBreak = function(n) {
    if(n < 4) return n-1;
    var dp = [2,0];
    for(var i = 5; i <= n; ++i) {
        if(!dp[0]) {
            dp[1]--;
            dp[0] = 2;
        }
        else {
            dp[0]--;
            dp[1]++;
        }
    }
    return (1 << dp[0])*(Math.pow(3, dp[1]));
};
