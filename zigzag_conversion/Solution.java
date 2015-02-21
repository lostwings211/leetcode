public class Solution {
    public String convert(String s, int nRows) {
        if(nRows <= 1) return s;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < nRows; i++) {
            if(i == 0) {
                int start = 0;
                while (start < length) {
                    sb.append(s.charAt(start));
                    start +=  2 * (nRows - 1);
                }
            }
            else if(i ==  nRows - 1) {
                int start =  nRows - 1;
                while (start < length) {
                    sb.append(s.charAt(start));
                    start += 2 * (nRows - 1);
                }
            }
            else {
                int start = i;
                int end = 2 * (nRows - 1) - i;
                
                while(end < length) {
                    sb.append(s.charAt(start));
                    sb.append(s.charAt(end));
                    start +=  2 * (nRows - 1);
                    end += 2 * (nRows - 1);
                }
                if (start < length) {
                    sb.append(s.charAt(start));
                }
            }
        }
        return sb.toString();
    }
}
