public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) return -1;
        if(A.length == 1) {
            return (A[0] == target) ? 0 : -1;
        }
        int half = -1;
        int pivot = A.length - 1;
        int i = 0;
        int j = A.length -1;
        while (true) {
            if(j-i == 1) {
                if( A[i] > A[j]) {
                    pivot = i;
                } 
                break;
            }
            half = (i+j) / 2;
            if(A[half] >= A[i] && A[half] <= A[j]) {
                break;
            }
            else if(A[half] >= A[i]) {
                i = half;
            }
            else {
                j = half;
            }
        }
        
        i = 0;
        j = A.length - 1;
        while ( i <= j) {
            half = (i + j) / 2;
            int transformed_half = (half + 1 + pivot) % A.length;
            if(A[transformed_half] == target) {
                return transformed_half;
            }
            else if (A[transformed_half] < target) {
                i = half + 1;
            }
            else {
                j = half - 1;
            }
        }
        return -1;
    }
}
