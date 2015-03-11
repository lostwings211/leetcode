public class Solution {
    public int minDistance(String word1, String word2) {
        int length_1 = word1.length();
        int length_2 = word2.length();
        
        int matrix[][] = new int[length_1 + 1][length_2 + 1];
        matrix[0][0] = 0;
        for(int i = 1; i <= length_1; i++) {
            matrix[i][0] = i;
        }
        for(int i = 1; i <= length_2; i++) {
            matrix[0][i] = i;
        }
        
        for(int i = 1; i <= length_1; i++) 
            for(int j = 1; j <= length_2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1];
                }
                else {
                    int smallest = Math.min(matrix[i-1][j] + 1, matrix[i][j-1] + 1);
                    smallest = Math.min(smallest, matrix[i-1][j-1] + 1);
                    matrix[i][j] = smallest;
                }
            }
        
        return matrix[length_1][length_2];
    }
}
