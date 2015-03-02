public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int step = 0;
        int last_reach = 0;
        int max_reach = 0;
        for(int i = 0; i<= max_reach && i < A.length; i++) {
            if(i > last_reach) {
                step++;
                last_reach = max_reach;
            }
            if(A[i] + i > max_reach) {
                max_reach = A[i] + i;
            }
        }
        if(max_reach < A.length - 1) {
            return 0;
        }
        return step;
    }
    
    public int jump_normal(int[] A) {
        int[] cost = new int[A.length]; 
        for(int i = A.length - 1; i >=0; i--) {
            if(i + A[i] >= A.length - 1) {
                cost[i] = 1;
            }
            else {
                int min_hops = Integer.MAX_VALUE;
                for(int k = i + 1; k <= i + A[i]; k++) {
                    if(cost[k] > 0 && cost[k] < min_hops) {
                        min_hops = cost[k];
                        if(min_hops == 1) {
                            break;
                        }
                    }
                }
                if(min_hops < Integer.MAX_VALUE) {
                    cost[i] = min_hops + 1;
                }
            }
        }
        return cost[0];
    }
    
    public int jump_recursive(int[] A) {
        int start = 0; 
        int end = A.length - 1;
        return calc(A, start, end);
    }
    
    public int calc(int[] A, int start, int end) {
        if(A[start] + start >= end) {
            return 1;
        }
        else {
            int min_hops = Integer.MAX_VALUE;
            for(int i = start +  1; i <= A[start] + start; i++) {
                if(A[i] != 0) {
                    int curr_hops = calc(A, i, end);
                    if (curr_hops <= min_hops) {
                        min_hops = curr_hops;
                    }
                }
            }
            return min_hops + 1;
        }
    }
}
