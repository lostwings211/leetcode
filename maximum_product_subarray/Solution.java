public class Solution {
    public int maxProduct(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        int localmax = A[0];
        int localmin = A[0];
        
        for(int i = 1; i < A.length; i++) {
            int pre_max = localmax;
            int pre_min = localmin;
            localmax = Math.max(pre_max*A[i], A[i]);
            localmax = Math.max(localmax, pre_min*A[i]);
            localmin = Math.min(pre_max*A[i], A[i]);
            localmin = Math.min(localmin, pre_min*A[i]);
            if(localmax > max) {
                max = localmax;
            }
        }
        return max;
    }
}
