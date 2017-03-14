public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int rows = board.length;
        if(rows < 0) {
            return board;
        }
        int cols = board[0].length;
        if(cols < 0) {
            return board;
        }
        boolean[][] visited = new boolean[rows][cols];
        updateBoard_recursive(board, visited, click);
        return board;
    }
    
    public void updateBoard_recursive(char[][] board, boolean[][] visited, int[] click) {
        int rows = board.length;
        int cols = board[0].length;
        int i = click[0];
        int j = click[1];
        char curr = board[i][j];
        if(curr == 'M') {
            board[i][j] = 'X';
            return;
        }
        else if(curr == 'E') {
            List<List<Integer>> neibours = new ArrayList<List<Integer>>();
            List<Integer> item = new ArrayList<Integer>();
            int nearbyMines = 0;
            if(i - 1 >= 0 && j - 1 >= 0) {
                if(board[i-1][j-1] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i-1][j-1] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i-1);
                    item.add(j-1);
                    neibours.add(item);
                }
            }
            if(i - 1 >= 0) {
                if(board[i-1][j] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i-1][j] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i-1);
                    item.add(j);
                    neibours.add(item);
                }
            }
            if(i - 1 >= 0 && j + 1 < cols) {
                if(board[i-1][j+1] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i-1][j+1] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i-1);
                    item.add(j+1);
                    neibours.add(item);
                }
            }
            if(j - 1 >= 0) {
                if(board[i][j-1] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i][j-1] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i);
                    item.add(j-1);
                    neibours.add(item);
                }
            }
            if(j + 1 < cols) {
                if(board[i][j+1] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i][j+1] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i);
                    item.add(j+1);
                    neibours.add(item);
                }
            }
            if(i + 1 < rows && j - 1 >= 0) {
                if(board[i+1][j-1] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i+1][j-1] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i+1);
                    item.add(j-1);
                    neibours.add(item);
                }
            }
            if(i +1 < rows) {
                if(board[i+1][j] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i+1][j] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i+1);
                    item.add(j);
                    neibours.add(item);
                }
            }
            if(i +1 < rows && j + 1 < cols) {
                if(board[i+1][j+1] == 'M') {
                    nearbyMines++;    
                }
                else if(visited[i+1][j+1] == false) {
                    item = new ArrayList<Integer>();
                    item.add(i+1);
                    item.add(j+1);
                    neibours.add(item);
                }
            }
            
            if(nearbyMines > 0) {
                board[i][j] = (char)(nearbyMines + '0');
                return;
            }
            else {
                board[i][j] = 'B';
                visited[i][j] = true;
                for(List<Integer> neibour : neibours) {
                    int[] curr_click = new int[2];
                    curr_click[0] = neibour.get(0);
                    curr_click[1] = neibour.get(1);
                    updateBoard_recursive(board, visited, curr_click);
                }
             }
        }
        return;
    }
}
