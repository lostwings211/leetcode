import java.util.*;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = (m != 0) ? matrix[0].length : 0;
        if(m == 0 || n == 0) {
            return 0;
        }
        int height[][] =  new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {
                    height[i][j] = 0;
                }
                else {
                    height[i][j] =  i == 0 ? 1 : height[i-1][j] + 1;
                }
            }
        
        for(int i = 0; i < m; i++) {
            max =  Math.max(max, largestRectangleArea(height[i]));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int h[] = Arrays.copyOf(height, height.length + 1);
        int i = 0;
        int max = 0;
        while(i < h.length) {
            if(stack.empty() || h[stack.peek()] <= h[i]) {
                stack.push(i);
                i++;
            }
            else {
                int top = stack.pop();
                max = Math.max(max, stack.empty()? h[top] * i : h[top] * (i - stack.peek() - 1));
            }
        }
        return max;
    }
}
