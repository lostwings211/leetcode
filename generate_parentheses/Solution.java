import java.util.*;
public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> ret =  new ArrayList<String>();
        if( n <= 0 ) {
            ret.add("");
            return ret;
        }
        String item = "";
        dfs(ret, 0, 0, n, item);
        return ret;
    }
    
    public static void dfs(List<String> ret, int left, int right, int pairs, String item) {
        
        if(right > left || left > pairs) {
            return;
        }
        if ( left == right && left == pairs) {
            ret.add(item);
            return;
        }

        dfs(ret, left + 1, right, pairs, item + "(");
        dfs(ret, left, right + 1, pairs, item + ")");
    }

    public static List<String> generateParenthesis_iterative(int n) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Integer> diff = new ArrayList<Integer>();
  
        result.add("");
        diff.add(0);
  
        for (int i = 0; i < 2 * n; i++) {
            ArrayList<String> temp1 = new ArrayList<String>();
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
  
            for (int j = 0; j < result.size(); j++) {
                String s = result.get(j);
                int k = diff.get(j);
  
                if (i < 2 * n - 1) {
                    temp1.add(s + "(");
                    temp2.add(k + 1);
                }
  
                if (k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n - 1) {
                    temp1.add(s + ")");
                    temp2.add(k - 1);
                }
            }
  
            result = new ArrayList<String>(temp1);
            diff = new ArrayList<Integer>(temp2);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ret =  generateParenthesis(2);
        for(String curr : ret) {
            System.out.println(curr);
        }
    }
}
