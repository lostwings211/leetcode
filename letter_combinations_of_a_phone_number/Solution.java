import java.util.*;
public class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0 ) {
            result.add("");
            return result;
        }
        String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder item = new StringBuilder();
        dfs(digits, map, item, 0, result);
        return result;
    }

    public static void dfs(String digits, String[] map, StringBuilder item, int index, List<String> result) {
        if(index == digits.length()) {
            result.add(item.toString());
        }
        else {
            char curr_digit = digits.charAt(index);
            if(map[curr_digit - '0'].length() == 0) {
                dfs(digits, map, item, index + 1, result);
            }
            else {
                for(int i = 0; i < map[curr_digit - '0'].length(); i++) {
                    item.append(map[curr_digit - '0'].charAt(i));
                    dfs(digits, map, item, index + 1, result);
                    item.deleteCharAt(item.length() -1);
                }
            }
        }
    }

    public static void main(String[] args) {
        String input = "12";
        List<String> ret =  letterCombinations(input);
        for(String curr : ret) {
            System.out.println(curr);
        }
    }
}
