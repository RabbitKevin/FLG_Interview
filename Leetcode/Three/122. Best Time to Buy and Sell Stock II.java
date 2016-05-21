public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int buy = -prices[0];
        int sell = 0;
        for(int i = 1; i < prices.length; ++i) {
            int tmp = Math.max(sell-prices[i], buy);
            sell = Math.max(sell, prices[i]+buy);
            buy = tmp;
        }
        return sell;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int left = 0;
        int right = 1;
        while(right < prices.length) {
            while(right < prices.length && prices[right] >= prices[right-1]) ++right;
            sum+=prices[right-1]-prices[left];
            left = right;
            right++;
        }
        return sum;
    }
}
