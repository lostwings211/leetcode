import java.util.*;
public class Solution {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int dp[] = new int[s.length()];
        dp[0] = validEncode(s.charAt(0)) ? 1 : 0;
        for(int i = 1; i < s.length(); i++) {
            if(validEncode(s.charAt(i)) == true) {
                dp[i] += dp[i-1];
            }
            if(validEncode(s.charAt(i-1), s.charAt(i)) == true) {
                if(i - 2 >= 0) {
                    dp[i] += dp[i-2];
                }
                else {
                    dp[i] += 1;
                }
            } 
        }
        return dp[s.length() -1];
    }

    public static int numDecodings_slow(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        dfs(stack, ret);
        return  ret.size();
    }
    
    public static void dfs(Stack<Character> stack, ArrayList<Integer> ret) {
        if(stack.empty()) {
            ret.add(1);
            return;
        }
        
        char curr_top = stack.pop();
        if(!stack.empty()) {
            char curr_top_next =  stack.pop();
            if(validEncode(curr_top_next, curr_top) == true) {
                dfs(stack, ret);
            }
            stack.push(curr_top_next);
        }
        if(validEncode(curr_top)) {
            dfs(stack, ret);
        }
        stack.push(curr_top);
    }
    
    public static boolean validEncode(char first) {
        if( first - '1' >= 0 && first - '1' <= 8) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean validEncode(char first, char second) {
        if (first == '1') {
            return true;
        }
        if(first == '2' && second - '0' <= 6 && second - '0' >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
        System.out.println(numDecodings(input));
    }
}
