public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ret = {-1, -1};
        if (A == null || A.length < 1) {
            return ret;
        }
        int half = -1;
        int i = 0;
        int j = A.length - 1;
        while ( true ) {
            half = (i+j)/2;
            if(A[half] == target) {
                int curr = half;
                while(curr - 1 >= 0 && A[curr - 1] ==  target) {
                    curr--;
                }
                ret[0] = curr;
                curr = half;
                while(curr + 1 <= A.length - 1 && A[curr + 1] == target) {
                    curr++;
                }
                ret[1] =  curr;
                return ret;
            }
            else if (A[half] < target) {
                i = half + 1;
            }
            else {
                j = half - 1;
            }
            if(i > j) {
                break;
            }
        }
        return ret;
    }
}
