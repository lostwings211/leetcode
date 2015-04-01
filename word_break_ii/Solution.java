import java.util.*;
public class Solution {
    public boolean wordBreak_first(String s, Set<String> dict) {
        if(s == null || s.length() == 0) {
            return false;
        }
        boolean dp[] = new boolean[s.length()];
        for(int i = 0; i < dp.length; i++) {
            if(dict.contains(s.substring(0,i+1))) {
                dp[i] = true;
            }
            else {
                for(int j = 1; j <= i; j++) {
                    String substring_second =  s.substring(j, i + 1);
                    if(dp[j-1] && dict.contains(substring_second)) {
                        dp[i] =  true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length -1];
    }
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0) {
            return convert(ret);
        }
        ArrayList<String> item = new ArrayList<String>();
        if(wordBreak_first(s,dict)) {
            dfs(s, item, dict, ret);
        }
        return convert(ret);
    }
    
    public void dfs(String s, ArrayList<String> item, Set<String> dict, ArrayList<ArrayList<String>> ret) {
        if(s.length() == 0) {
            ret.add(new ArrayList<String>(item));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String substring_first = s.substring(0, i);
            String substring_second = s.substring(i, s.length());
            if(dict.contains(substring_first) && (substring_second.length() == 0 || wordBreak_first(substring_second, dict))) {
                item.add(substring_first);
                dfs(substring_second, item, dict, ret);
                item.remove(item.size()-1);
            }
        }
    }
    
    public ArrayList<String> convert(ArrayList<ArrayList<String>> input) {
        ArrayList<String> ret = new ArrayList<String>();
        for(ArrayList<String> curr: input) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < curr.size(); i++) {
                if(i != curr.size() - 1) {
                    sb.append(curr.get(i) + " ");
                }
                else {
                    sb.append(curr.get(i));
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}
