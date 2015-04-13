public class Solution {
    public int rob(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        int dp_local[] =  new int[num.length];
        int dp_global[] = new int[num.length];
        for(int i = 0; i < num.length; i++) {
            if(i - 3 >= 0) {
                dp_local[i] = Math.max(dp_local[i-3] + num[i], dp_local[i-2] + num[i]);
                dp_global[i] = Math.max(dp_local[i], dp_global[i-1]);
            }
            else if(i - 2 >= 0) {
                dp_local[i] = Math.max(num[i], dp_local[i-2] + num[i]);
                dp_global[i] = Math.max(dp_local[i], dp_global[i-1]);
            }
            else {
                dp_local[i] = num[i];
                if(i - 1 >= 0) {
                    dp_global[i] = Math.max(dp_local[i], dp_global[i-1]);
                }
                else {
                    dp_global[i] =  num[i];
                }
            }
        }
        
        return dp_global[num.length -1];
    }
}
