/*

*/
var wordBreak = function(s, wordDict) {
    var dp = [true];
    for(var i = 1; i <= s.length; ++i) {
        var result = false;
        for(var j = i; j;--j) {
            if(wordDict.has(s.substring(j-1, i)) && dp[j-1]) {
                result = true;
                break;
            }
        }
        dp.push(result);
    }
    return dp[s.length];
};
