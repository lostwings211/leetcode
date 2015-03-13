import java.util.*;
public class Solution {
    public int removeDuplicates(int[] A) {
        int start = 0;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(i == 0 || A[i] != A[i-1]) {
                count = 0;
            }
            count++;
            if(count <= 2) {
                A[start++] = A[i];
            }
        }
        return start;
    }
    
    public int removeDuplicates_slow(int[] A) {
        if(A.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int start = 0;
        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(A[i])) {
                if(map.get(A[i]) >= 2) {
                    continue;   
                }
                else {
                    map.put(A[i], map.get(A[i]) + 1);
                    A[start++] = A[i];
                }
            }
            else {
                map.put(A[i], 1);
                A[start++] = A[i];
            }
        }
        return start;
    }
}
