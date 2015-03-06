public class Solution {
    public boolean canJump(int[] A) {
        int max_reach = 0;
        int curr_reach = 0;
        for(int i = 0; i <= max_reach; i++) {
            curr_reach = A[i] + i;
            if(curr_reach >= A.length - 1) {
                return true;
            }
            if(curr_reach > max_reach) {
                max_reach = curr_reach;
            }
        }
        return false;
    }
}
