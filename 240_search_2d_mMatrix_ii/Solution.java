public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return false;
        }
        int i = m - 1;
        int j = 0;
        while(true) {
            if(matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] < target) {
                j++;
            }
            else {
                i--;
            }
            
            if(i < 0 || j >= n) {
                break;
            }
        }
        return false;       
    }
}
