import java.util.*;
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int A_copy[] = Arrays.copyOf(A, m);
        int i = 0;
        int j = 0;
        int index = 0;
        while ( i < m || j < n) {
            if(i == m) {
                for(int index_b =  j; index_b < n; index_b++) {
                    A[index++] = B[index_b];
                }
                return;
            }
            if(j == n) {
                for(int index_a = i; index_a < m; index_a++) {
                    A[index++] = A_copy[index_a];
                }
                return;
            }
            if(A_copy[i] <= B[j]) {
                A[index++] = A_copy[i++];
            }
            else {
                A[index++] =  B[j++];
            }
        }
    }
}
