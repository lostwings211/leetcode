import java.util.*;
public class Solution {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        if (height == 0) {
            return;
        }
        int width = matrix[0].length;
        HashMap<Integer, Boolean> map_row = new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> map_col = new HashMap<Integer, Boolean>();
        
        for(int i = 0; i < height; i++) 
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) {
                    if(map_row.containsKey(i) == false) {
                        map_row.put(i, true);
                    }
                    if(map_col.containsKey(j) == false) {
                        map_col.put(j, true);
                    }
                }
            }
            
        for (int row : map_row.keySet()) {
            for(int i = 0; i < width; i++) {
                matrix[row][i] = 0;
            }
        }
        
        for (int col : map_col.keySet()) {
            for(int i = 0; i  < height; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
