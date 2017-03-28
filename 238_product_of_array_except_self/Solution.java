public class Solution {
        public int[] productExceptSelf(int[] nums) {
                    int[] ret = new int[nums.length];
                            int p = 1;
                                    for(int i = 0; i < nums.length; i++) {
                                                    if(i == 0) {
                                                                        p = 1;
                                                                                    }
                                                                else {
                                                                                    p = p * nums[i-1];
                                                                                                }
                                                                            ret[i] = p;
                                                                                    }
                                            
                                            p = 1;
                                                    for(int i = nums.length - 1; i >= 0; i--) {
                                                                    if(i == nums.length - 1) {
                                                                                        p = 1;
                                                                                                    }
                                                                                else {
                                                                                                    p = p * nums[i+1];
                                                                                                                }
                                                                                            ret[i] =  p * ret[i];
                                                                                                    }
                                                            return ret;
                                                                }
}
