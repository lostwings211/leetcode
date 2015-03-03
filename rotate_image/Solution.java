public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length <= 1) {
            return;
        }
        int matrix_copy[][] = new int[length][length];
        for(int i = 0; i < length; i++)
            for(int j = 0; j < length; j++) {
                matrix_copy[j][length - 1 - i] = matrix[i][j];
            }
            
        for(int i = 0; i < length; i++)
            for(int j = 0; j < length; j++) {
            matrix[i][j] = matrix_copy[i][j];
        }
    }
}
