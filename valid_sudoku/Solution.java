public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length_x = board.length;
        if (length_x <= 0) return false;
        int length_y = board[0].length;
        int subSquare_size = (int)Math.sqrt(length_x);
        
        //check Rows
        for(int i = 0; i < length_x; i++) {
            if(containUnique(board, i, 0, i, length_y -1) == false) {
                return false;
            }
        }
        
        //check Columns
        for(int i = 0; i < length_y; i++) {
            if(containUnique(board, 0, i, length_x - 1, i) ==  false) {
                return false;
            }
        }
        
        //Check SubSquares 
        for(int i = 0; i<= length_x - subSquare_size; i+= subSquare_size) 
            for(int j = 0; j <= length_y - subSquare_size; j+= subSquare_size) {
                  if (containUnique(board, i, j, i + subSquare_size - 1, j + subSquare_size - 1 ) == false) {
                      return false;
                  }
            }
        
        return true;
    }
    
    public boolean containUnique(char[][] board, int start_x, int start_y, int end_x, int end_y) {
        boolean[] map = new boolean[9];
        
        for(int i = start_x; i<= end_x; i++) 
            for(int j = start_y; j <= end_y; j++) {
                char curr_char = board[i][j];
                if(curr_char != '.') {
                    if(map[(int)curr_char - (int)'1'] == true) {
                        return false;
                    }
                    map[(int)curr_char - (int)'1'] = true;
                }
            }
        return true;
    }
}
