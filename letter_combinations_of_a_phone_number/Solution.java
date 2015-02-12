import java.util.*;
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length() > 0) {
            result = dfs(map, digits, digits.length() - 1);
        }
        else {
            result.add(digits);
        }    
        return result;
    }
    
    public List<String> dfs(String[] map, String digits, int index) {
        
        if(index == 0) {
            List<String> result = new ArrayList<String>();
            String curr_map = map[digits.charAt(index) - '0'];
            if(curr_map.length() == 0) {
                result.add("");
            }
            else {
                for(int i = 0; i < curr_map.length(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(curr_map.charAt(i));
                    result.add(sb.toString());
                }
            }
            return result;
        }
        else {
            List<String> result = dfs(map, digits, index-1);
            List<String> result_new = new ArrayList<String>();
            String curr_map = map[(int)digits.charAt(index) - '0'];
            if(curr_map.length() == 0) {
                return result;
            }
            for(String ret : result) {
                for(int i = 0; i< curr_map.length(); i++) {
                    result_new.add(ret + curr_map.charAt(i));
                }
            }
            return result_new;
        }        
    }
}
