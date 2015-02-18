public class Solution {
    public int removeElement(int[] A, int elem) {
        int length = A.length;
        int count = 0;
        int i = 0;
        while ( i <= length - 1 - count) {
            if(A[i] == elem) {
                int temp = A[i];
                A[i] = A[length - 1 - count];
                A[length -1 - count] = temp;
                count++;
                continue;
            }
            i++;
        }
        return (length-count);
    }
}
