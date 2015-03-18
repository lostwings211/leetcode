import java.util.*;
public class Solution {
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if(s.length() < 4 || s.length() > 12) {
            return Convert(ret);
        }
        ArrayList<String> item = new ArrayList<String>();
        dfs(0, s, item, ret);
        return Convert(ret);
    }
    
    public static void dfs(int start, String s, ArrayList<String> item, ArrayList<ArrayList<String>> ret) {
        if(item.size() == 4) {
            if(start == s.length()) {
                ret.add(new ArrayList<String>(item));
            }
            return;
        }
        if(start >= s.length()) {
            return;
        }
        
        for(int i = 0; i <= 2; i++) {
            if(start + i < s.length()) {
                String number = s.substring(start, start+1+i);
                int remain_length =  s.length() - start - i - 1;
                int remain_decimal = 4 - item.size() - 1;
                if (validNumber(number) &&  remain_length >= remain_decimal && remain_length <= 3*remain_decimal) {
                    item.add(number);
                    dfs(start+1+i, s, item, ret);
                    item.remove(item.size() - 1);
                }    
            }
        }
    }
    
    public static boolean validNumber(String s) {
        if(s.length() == 1) {
            return true;
        }
        if(s.length() == 2) {
            if(s.charAt(0) == '0') {
                return false;
            }
            return true;
        }
        if(s.length() ==  3) {
            if(s.charAt(0) == '0') {
                return false;
            }
            int num = Integer.parseInt(s);
            if(num > 255) {
                return false;
            }
            return true;
        }
        return true;
    }
    
    public static ArrayList<String> Convert(ArrayList<ArrayList<String>> input) {
        ArrayList<String> ret = new ArrayList<String>();
        for(ArrayList<String> curr_list: input) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < curr_list.size(); i++) {
                sb.append(curr_list.get(i));
                if(i != curr_list.size() - 1) {
                    sb.append('.');
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }
    
    public static void main(String[] args) {
          ArrayList<String> ret =  restoreIpAddresses("010010");
          for(String curr: ret) {
              System.out.println(curr);
          }
    }
}
