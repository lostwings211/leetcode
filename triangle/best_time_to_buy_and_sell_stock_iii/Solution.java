public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int A[] =  new int[prices.length];
        int B[] =  new int[prices.length];
        
        int curr_min = prices[0];
        for(int i = 1; i < A.length; i++) {
            if(prices[i] < curr_min) {
                curr_min = prices[i];
            }
            A[i] = Math.max(A[i-1], prices[i] - curr_min);
        }
        
        int curr_max = prices[prices.length -1];
        for(int i = B.length - 2; i >= 0; i--) {
            if(prices[i] > curr_max) {
                curr_max =  prices[i];
            }
            B[i] = Math.max(B[i+1], curr_max - prices[i]);
        }
        
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(A[i] + B[i] > max) {
                max = A[i] + B[i];
            }
        }
        return max;
    }
}
