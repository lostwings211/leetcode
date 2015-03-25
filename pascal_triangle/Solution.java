import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0) {
            return ret;
        }
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        ret.add(curr);
        
        for(int i = 1; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int size = curr.size();
            for(int index = 0; index <= size; index++) {
                if(index == 0) {
                    temp.add(curr.get(index));
                }
                else if(index == size) {
                    temp.add(curr.get(index - 1));
                }
                else {
                    temp.add(curr.get(index) + curr.get(index-1));
                }
            }
            ret.add(temp);
            curr = temp;
        }
        return ret;        
    }
}
