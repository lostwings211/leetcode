import java.util.*;
public class Solution {
    public int totalNQueens(int n) {
        int item[][] =  new int[n][n];
        boolean visited[] = new boolean[n];
        ArrayList<Integer> ret =  new ArrayList<Integer>();
        dfs(item, 0, n, visited, ret);
        return ret.size();
    }
    
    public static void dfs(int[][] item, int i, int n, boolean[] visited, ArrayList<Integer> ret) {
        if (i == n) {
            ret.add(1);
            return;
        }
        else {
            //find [i, x] as a location to put the queen
            for(int x = 0; x < n; x++) {
                if(visited[x] == false && validMatrix(item, i, x)) {
                    item[i][x] = 1;
                    visited[x] = true;
                    dfs(item, i + 1, n, visited, ret);
                    visited[x] = false;
                    item[i][x] = 0;
                }
            }
        }
    }

    public static boolean validMatrix(int[][] item, int i, int x) {
        int length = item.length;
        for(int index_line = 0; index_line < i; index_line++) {
            for(int index_row = 0; index_row < length; index_row++) {
                if(item[index_line][index_row] == 1) {
                    if( x - index_row ==  i - index_line || index_row -  x ==  i - index_line) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
