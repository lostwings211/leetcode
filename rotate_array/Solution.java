public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums != null) {
            int nums_bak[] =  new int[nums.length];
            for(int i = 0; i < nums.length; i++) {
                nums_bak[(i + k) % nums.length] = nums[i];
            }
            for(int i = 0; i < nums.length; i++) {
                nums[i] = nums_bak[i];    
            }
        }
    }
}
