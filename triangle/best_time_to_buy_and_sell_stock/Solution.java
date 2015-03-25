public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
    
    public int maxProfit_slow(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int dp[] = new int[prices.length];
        for(int i = 0; i < dp.length; i++) {
            if(i == 0) {
                dp[i] = i;
            }
            else {
                if(prices[i] >= prices[i-1]) {
                    dp[i] = dp[i-1];
                }
                else {
                    dp[i] = i;
                    for(int j = i - 1; j >= 0; j--) {
                        if(prices[i] - prices[j] > prices[i] - prices[dp[i]]) {
                            dp[i] = j;
                        }
                    }
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < dp.length; i++) {
            if(prices[i] - prices[dp[i]] > max) {
                max = prices[i] - prices[dp[i]];
            }
        }
        return max;
    }
}
