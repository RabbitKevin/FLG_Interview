/**
    main min buy price
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int max = 0,
        int min = prices[0];
        for(int price : prices) {
            max = Math.max(max, price-min);
            min = Math.min(price, min);
        }
        return max;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int max = 0,
        int min = prices[0];
        for(int price : prices) {
            max = Math.max(max, price-min);
            min = Math.min(price, min);
        }
        return max;
    }
}
