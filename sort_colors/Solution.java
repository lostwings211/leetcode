import java.util.*;
public class Solution {
    public void sortColors(int[] A) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                red++;
            }
            else if(A[i] == 1) {
                white++;
            }
            else if(A[i] == 2) {
                blue++;
            }
        }
        int index = 0;
        for(;index < red; index++) {
            A[index] = 0;
        }
        for(;index < red + white; index ++) {
            A[index] =  1;
        }
        for(; index < red + white + blue; index++) {
            A[index] = 2;
        }
    }
}
