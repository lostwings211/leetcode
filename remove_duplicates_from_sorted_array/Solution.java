public class Solution {
    public int removeDuplicates(int[] A) {
        int length = A.length;
        int i = 0;
        int count = 0;
        while(i < length) {
            while(i < length -1 && A[i] == A[i+1]) {
                i++;
            }
            //swap i and count
            int temp = A[i];
            A[i++] = A[count];
            A[count++] = temp;
        }
        return count;
    }
}
