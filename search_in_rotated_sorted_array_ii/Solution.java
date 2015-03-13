public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length == 0) {
            return false;
        }
        int pivot = 0;
        while(pivot < A.length - 1) {
            if(A[pivot] > A[pivot+1]) {
                break;
            }
            pivot++;
        }
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int half = (start + end) / 2;
            int converted_half =  (pivot + 1 + half) % A.length;
            if(target == A[converted_half]) {
                return true;
            }
            else if(target < A[converted_half]) {
                end = half - 1;
            }
            else {
                start = half + 1;
            }
        }
        return false;
    }
}
