import java.util.*;
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for(int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void fill(char[][] board, int row, int col) {
        if(board[row][col] != 'O') {
            return;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(row * board[0].length + col);
        board[row][col] = '#';
        while(!queue.isEmpty()) {
            int curr_indexes =  (int)queue.poll();
            int curr_row = curr_indexes / board[0].length;
            int curr_col = curr_indexes % board[0].length;
            
            if(curr_row - 1 >= 0 && board[curr_row - 1][curr_col] == 'O') {
                queue.offer((curr_row-1) * board[0].length + curr_col);
                board[curr_row - 1][curr_col] = '#';
            }
            if(curr_row + 1 < board.length && board[curr_row + 1][curr_col] == 'O') {
                queue.offer((curr_row+1) * board[0].length + curr_col);
                board[curr_row + 1][curr_col] = '#';
            }
            if(curr_col - 1 >= 0 && board[curr_row][curr_col - 1] == 'O') {
                 queue.offer(curr_row* board[0].length + curr_col - 1);
                 board[curr_row][curr_col - 1] = '#';
            }
            if(curr_col + 1  < board[0].length && board[curr_row][curr_col + 1] == 'O') {
                 queue.offer(curr_row* board[0].length + curr_col + 1);
                 board[curr_row][curr_col + 1] = '#';
            }
        }
    }
}
