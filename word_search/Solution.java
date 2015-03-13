import java.util.*;
public class Solution {
    public static boolean exist(char[][] board, String word) {
        int height = board.length;
        if(height == 0) {
            return false;
        }
        int width = board[0].length;
        if(width == 0) {
            return false;
        }
        boolean visited[][] =  new boolean[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if (dfs(0, i, j, height, width, visited, word, board) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean dfs(int index, int i, int j, int height, int width, boolean[][] visited, String word, char[][] board) {
        if(index == word.length()) {
            return true;
        }
        else if( i < 0 || i >= height || j < 0 || j >= width) {
            return false;
        }
        else if(visited[i][j] == true) {
            return false;
        }
        else {
            if(board[i][j] == word.charAt(index)) {
                visited[i][j] = true;
                boolean ret =  (dfs(index + 1, i + 1, j, height, width, visited, word, board) ||
                                dfs(index + 1, i, j + 1, height, width, visited, word, board) ||
                                dfs(index + 1, i - 1, j, height, width, visited, word, board) ||
                                dfs(index + 1, i, j - 1, height, width, visited, word, board));
                visited[i][j] = false;
                return ret;
            }   
            else {
                return false;
            }
        }
    }
}
