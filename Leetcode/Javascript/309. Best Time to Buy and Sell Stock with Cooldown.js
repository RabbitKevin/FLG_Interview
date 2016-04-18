/*
  Process of thinking,
  https://leetcode.com/discuss/71354/share-my-thinking-process
*/
//Time O(n), Space O(n)
var maxProfit = function(prices) {
    if(prices.length < 2) return 0;
    var buy = [-prices[0], -Math.min(prices[1], prices[0])];
    var sell = [0, Math.max(prices[1]-prices[0], 0)];
    for(var i = 2; i < prices.length; ++i) {
        buy.push(Math.max(buy[i-1], sell[i-2]-prices[i]));
        sell.push(Math.max(sell[i-1], buy[i-1]+prices[i]));
    }
    return sell[i-1];
};
//Time O(n), Space O(n)
var maxProfit = function(prices) {
    var sell_cur = 0,
        sell_bfe = 0,
        buy_cur = Number.NEGATIVE_INFINITY,
        buy_bfe;
    prices.forEach(function(price) {
        buy_bfe = buy_cur;
        buy_cur = Math.max(buy_bfe, sell_bfe-price);
        sell_bfe = sell_cur;
        sell_cur = Math.max(buy_bfe+price, sell_bfe);
    });
    return sell_cur;
};
