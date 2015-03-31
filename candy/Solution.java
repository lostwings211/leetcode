public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int minSum = ratings.length;
        int candy[] =  new int[ratings.length];
        int currCandy = 0;
        
        for(int i =  1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                currCandy++;
            }    
            else {
                currCandy = 0;
            }
            candy[i] =  currCandy;
        }
        currCandy = 0;
        for(int i =  ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                currCandy++;
            }
            else {
                currCandy = 0;
            }
            minSum += Math.max(currCandy, candy[i]);
        }
        minSum += candy[ratings.length -1];
        return minSum;
    }
}
