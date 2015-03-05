public class Solution {
    public int maxSubArray(int[] A) {
        int max_sofar = 0;
        int max_end_here = 0;
        int max_value = Integer.MIN_VALUE;
        
        for (int i = 0; i< A.length; i++) {
            max_end_here += A[i];
            if(max_end_here < 0) {
                max_end_here = 0;
            }
            
            if(max_end_here > max_sofar) {
                max_sofar = max_end_here;
            }
            if(A[i] > max_value) {
                max_value = A[i];
            }
        }
        return max_sofar > 0 ? max_sofar : max_value;
    }
}
