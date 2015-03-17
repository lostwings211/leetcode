import java.util.*;
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(n <= 0) {
            ret.add(0);
            return ret;
        }
        ret = grayCode(n-1);
        int length = ret.size();
        for(int i = length - 1; i >= 0; i--) {
            int curr = ret.get(i) + (int) Math.pow(2, n-1);
            ret.add(curr);
        }
        return ret;
    }
}
