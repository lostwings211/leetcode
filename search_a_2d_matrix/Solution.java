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
        
        int start = 0;
        int end = m*n -1;
        while (start <=  end) {
            int curr_half = (start + end) / 2;
            int row = curr_half / n;
            int col = curr_half - row * n;
            if(matrix[row][col] ==  target) {
                return true;
            }
            else if(matrix[row][col] < target) {
                start = curr_half +  1;
            }
            else {
                end = curr_half - 1;
            }
        }
        return false;
    }
}
