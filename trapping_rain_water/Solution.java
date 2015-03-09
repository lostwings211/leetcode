public class Solution {
    public static int trap(int[] A) {
        int ret = 0;
        if(A.length <= 2) {
            return ret;
        }
        int left_wall = 0;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] < A[i+1]) {
                int curr_index = i - 1;
                while ( curr_index >= left_wall ) {
                    if(A[curr_index] > A[i]) {
                        int min_walls = Math.min(A[curr_index], A[i+1]);
                        System.out.println("(" + curr_index + ", " + i + ", " + (i+1) + ") : " +  (min_walls - A[i]) * (i - curr_index ));
                        ret +=  (min_walls - A[i]) * (i - curr_index );
                        //注水
                        for(int j = curr_index +  1; j <= i; j++) {
                            A[j] = min_walls;
                        }
                        if(min_walls == A[i+1]) {
                            break;
                        }
                    }
                    curr_index--;
                }
                if(A[i+1] > A[left_wall]) {
                    left_wall = i + 1;
                }
            }    
        }
        return ret;
    }

    public static void main(String[] args) {
        int input[] =  new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(input));
    }
}
