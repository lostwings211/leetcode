import java.util.HashMap; 

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[]{0,0};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])) {
                results[0] = map.get(numbers[i]) + 1;
                results[1] = i + 1;
                break;
            }
            else {
                map.put(target - numbers[i], i);
            }
        }
        return results; 	
    }	
	
    public int[] twoSum_sorted(int[] numbers, int target) {
        int[] results = new int[]{0,0};
        int i = 0;
        int j = numbers.length - 1;
        while ( i < j) {
            if(numbers[i] + numbers[j] ==  target) {
                results[0] =  i + 1;
                results[1] =  j + 1;
                break;
            }
            else if (numbers[i] + numbers[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return results;
    }
}
