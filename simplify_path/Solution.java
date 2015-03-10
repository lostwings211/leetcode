public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.trim().split("/");
        if(paths.length == 0) {
            paths = new String[] {""};
        }
        String[] stack_paths = new String[paths.length];
        int top = -1;
        
        for (int i = 0; i < paths.length; i++) {
            String curr_string = paths[i];
            if(curr_string.equals(".")) {
                continue;
            }
            else if(curr_string.equals("")) {
                if(i == 0) {
                    stack_paths[++top] = curr_string;
                }
            }
            else if (curr_string.equals("..")) {
                if(top >= 0 && !stack_paths[top].equals("")) {
                    top--;
                }
            }
            else {
                stack_paths[++top] = curr_string;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= top; i++) {
            if(!stack_paths[i].equals("")) {
                sb.append("/" + stack_paths[i]);
            }
            else {
                if(top == 0){
                    sb.append("/");
                }
            }
        }
        return sb.toString();
    }
}
