public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        if (n == 1) return "1";
        
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < prev.length()) {
            int count = 1;
            int curr_index = index;
            while(curr_index +  1 < prev.length() && prev.charAt(curr_index) == prev.charAt(curr_index + 1)) {
                curr_index++;
                count++;
            }
            index = curr_index + 1;
            sb.append(Integer.toString(count));
            sb.append(prev.charAt(curr_index));
        }
        return sb.toString();
    }
}
