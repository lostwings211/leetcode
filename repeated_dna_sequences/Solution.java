import java.util.*;
public class Solution {
    public ArrayList<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer, Integer> visit = new HashMap<Integer, Integer>();
        ArrayList<String> ret = new ArrayList<String>();
        if(s == null || s.length() <= 10) {
            return ret;
        }
        for(int i = 0; i <= s.length() - 10; i++) {
            String curr_str = s.substring(i, i + 10);
            int curr_code = convert(curr_str);
            if(visit.containsKey(curr_code)) {
                int curr_visit =  visit.get(curr_code);
                if(curr_visit == 1) {
                    ret.add(curr_str);
                }
                visit.put(curr_code, curr_visit + 1);
            }
            else {
                visit.put(curr_code, 1);
            }
        }
        return ret;
    }
    
    public int convert(String input) {
        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            switch (curr) {
                case 'A':
                    sum += 10*sum + 1;
                    break;
                case 'C':
                    sum += 10*sum + 2;
                    break;
                case 'G':
                    sum += 10*sum + 3;
                    break;
                case 'T':
                    sum += 10*sum + 4;
                    break;
            }
        }
        return sum;
    }
}
