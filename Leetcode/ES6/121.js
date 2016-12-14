var maxProfit = function(prices) {
    if(!prices.length) return 0;
    let min = prices[0];
    let max = 0;
    for(let i = 0; i < prices.length; ++i) {
        min = Math.min(prices[i], min);
        max = Math.max(max, prices[i]-min);
    }
    return max;
};
