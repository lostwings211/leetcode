public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        int min = num[0];
        for(int i = 1; i < num.length; i++) {
            if(num[i] < num[i-1]) {
                return num[i];
            }
        }
        return min;
    }
}
