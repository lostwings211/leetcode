import java.util.*;
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> item = new ArrayList<String>();
        dfs(s, item, ret);
        return ret;
    }
    
    public void dfs(String s, ArrayList<String> item, ArrayList<ArrayList<String>> ret) {
        if(s.length() == 0) {
            ret.add(new ArrayList<String>(item));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String curr_sub = s.substring(0, i);
            if(isPalindrome(curr_sub)) {
                item.add(curr_sub);
                dfs(s.substring(i, s.length()), item, ret);
                item.remove(item.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
