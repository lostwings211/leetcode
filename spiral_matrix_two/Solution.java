public class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int i = 0;
        int j = 0;
        int up_limit = 0;
        int down_limit = n -1;
        int left_limit = 0;
        int right_limit = n - 1;
        char direction = 'r';
        for (int index = 1; index <= n*n; index++) {
            matrix[i][j] = index;
            switch (direction) {
                case 'r':
                    if(j == right_limit) {
                        i++;
                        direction = 'd';
                        up_limit++;
                    }
                    else {
                        j++;
                    }
                    break;
                case 'd':
                    if(i == down_limit) {
                        j--;
                        direction = 'l';
                        right_limit--;
                    }
                    else {
                        i++;
                    }
                    break;
                case 'l':
                    if(j == left_limit) {
                        i--;
                        direction = 'u';
                        down_limit--;
                    }
                    else {
                        j--;
                    }
                    break;
                case 'u':
                    if(i == up_limit) {
                        j++;
                        direction = 'r';
                        left_limit++;
                    }
                    else {
                        i--;
                    }
                    break;
                default:
                    break;
            }
        }
        return matrix;
    }
}
