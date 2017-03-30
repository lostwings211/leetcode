public class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0) {
            return 0;
        }
        int sum = 0;
        int t = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            t += i * A[i];
        }
        int max = t;
        for(int i = 1; i < A.length; i++) {
            t = t + sum - A.length * A[A.length - i];
            if(t >= max) {
                max = t;
            }
        }
        return max;
    }
    
    public int maxRotateFunction_slow(int[] A) {
        if(A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int length = A.length;
        for(int i = 0; i < length; i++) {
            int curr_val = 0;
            for(int j = 0; j < length; j++) {
                curr_val += j * A[(length + j - i) % length];
            }
            if(curr_val >= max) {
                max = curr_val;
            }
        }
        return max;
    }
}
