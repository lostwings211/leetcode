import java.util.*;
public class Solution {
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
    
    public int largestRectangleArea_slow(int[] height) {
        int max_rec = 0;
        int curr_min = 0;
        for (int i = 0; i < height.length; i++) {
            curr_min = height[i];
            for(int j = i; j < height.length; j++) {
                if(height[j] < curr_min) {
                    curr_min = height[j];
                }
                if(curr_min * (j - i + 1) > max_rec) {
                    max_rec = curr_min * (j - i + 1);
                }
            }
        }
        return max_rec;
    }
}
