public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.insert(0, Convert((n-1) % 26));
            n = (n-1) / 26;
        }
        return sb.toString();
    }
    
    public char Convert(int n) {
        return (char) ('A' + n );
    }
}
