public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        char[] stack = new char[length];
        int stack_index = -1;

        for(int i = 0; i < length; i++) {
            char curr_char = s.charAt(i);
            switch (curr_char) {
                case '(':
                case '[':
                case '{':
                    stack[++stack_index] = curr_char;
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack_index < 0) return false;
                    char pop_char =  stack[stack_index--];
                    if(curr_char == '}' && pop_char != '{') return false;
                    if(curr_char == ']' && pop_char != '[') return false;
                    if(curr_char == '}' && pop_char != '{') return false;
                    break;    
                default:
                    return false;
            }
        }
        if(stack_index >= 0) {
            return false;
        }
        else {
            return true;
        }
           
    }
}
