public class Solution {
	public static int MaxArea(int[] height) {
		int maxArea = 0;
        if(height == null) return maxArea;
		int length = height.length;
		int i = 0;
		int j = length - 1;
		while (i < j) {
			int minHeight = (height[i] < height[j]) ? height[i] : height[j];
			if ((j-i) * minHeight > maxArea) {
				maxArea = (j-i) * minHeight;
			}
			if (height[i] < height[j]) {
				i++;
			}
			else {
				j--;
			}
		}
		return maxArea;
	}
}
