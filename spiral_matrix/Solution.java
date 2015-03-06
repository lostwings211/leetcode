import java.util.*;
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int length = matrix.length;
        if(length == 0) {
            return ret;
        }
        int width = matrix[0].length;
        int i = 0;
        int j = 0;
        int up_limit = 0;
        int down_limit = length;
        int right_limit = width;
        int left_limit = 0;
        char scan_direction = 'r';
        while(ret.size() != length * width) {
            ret.add(matrix[i][j]);
            if(scan_direction == 'r') {
                if(j + 1 < right_limit) {
                    j++;
                }
                else {
                    i++;
                    up_limit++;
                    scan_direction = 'd';
                }
            }
            else if(scan_direction == 'd') {
                if(i +  1 < down_limit) {
                    i++;
                }
                else {
                    j--;
                    right_limit--;
                    scan_direction = 'l';
                }
            }
            else if(scan_direction == 'l') {
                if(j - 1 >= left_limit) {
                    j--;
                }
                else {
                    i--;
                    down_limit--;
                    scan_direction = 'u';
                }
            }
            else if (scan_direction == 'u') {
                if(i - 1 >= up_limit) {
                    i--;
                }
                else {
                    j++;
                    left_limit++;
                    scan_direction = 'r';
                }
            }
        }
        return ret;
    }
}
