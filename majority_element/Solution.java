import java.util.*;
public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> visit = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++) {
            if(!visit.containsKey(num[i])) {
                visit.put(num[i], 1);
                if(num.length == 1) {
                    return num[i];
                }
            }
            else {
                int count = visit.get(num[i]);
                visit.put(num[i],  count + 1);
                if(count + 1 > num.length / 2) {
                    return num[i];
                }
            }
        }
        return 0;
    }
}
