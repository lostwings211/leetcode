import java.util.*;
public class Solution {
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<int[][]> ret = new ArrayList<int[][]>();
        int item[][] =  new int[n][n];
        boolean visited[] = new boolean[n];
        dfs(item, 0, n, visited, ret);

        ArrayList<String[]> ret1 = Convert(ret);
        return ret1;
    }
    
    public static ArrayList<String[]> Convert(ArrayList<int[][]> ret) {
        ArrayList<String[]> ret1 = new ArrayList<String[]>();
        for(int[][] item : ret) {
            String[] curr_string = new String[item.length];
            for (int i = 0; i < item.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < item.length; j++) {
                    char currchar = item[i][j] == 1 ? 'Q' : '.';
                    sb.append(currchar);
                }
                curr_string[i] = sb.toString();
            }
            ret1.add(curr_string);
        }
        return ret1;
    }

    public static void dfs(int[][] item, int i, int n, boolean[] visited, ArrayList<int[][]> ret) {
        if (i == n) {
            ret.add(copyItem(item));
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

    public static int[][] copyItem(int[][] item) {
        int length =  item.length;
        int ret[][] =  new int[length][length];
        for(int i = 0; i< length; i++)
            for(int j =0; j < length; j++) {
                ret[i][j] = item[i][j];
            }
        return ret;
    }
    
    public static void main(String[] args) {
        ArrayList<String[]> ret = solveNQueens(2);
        for(String[] item : ret) {
            for(int i = 0; i < item.length; i++) {
                for(int j = 0; j < item.length; j++) {
                    System.out.print(item[i].charAt(j));
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }
}
