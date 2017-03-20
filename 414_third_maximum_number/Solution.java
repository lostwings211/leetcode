public class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        int third_max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= max) {
                max = nums[i];
            }
        }
        
        boolean exists_second_max = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < max && nums[i] >= second_max) {
                second_max = nums[i];
                exists_second_max = true;
            }
        }
        if(exists_second_max == false) {
            return max;
        }
        
        boolean exists_third_max = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < second_max && nums[i] >= third_max) {
                third_max = nums[i];
                exists_third_max = true;
            }
        }
        
        if (exists_third_max) {
            return third_max;
        }
        else {
            return max;
        }
    }
}
