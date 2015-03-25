import java.util.*;
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        if(rowIndex <= 0) {
            return curr;
        }
        for(int i = 0; i < rowIndex; i++) {
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
            curr = temp;
        }
        return curr;        
    }
}
