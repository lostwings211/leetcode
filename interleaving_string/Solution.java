public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if(s1.length() == 0) {
            return s2.equals(s3);
        }
        if(s2.length() == 0) {
            return s1.equals(s3);
        }

        boolean matrix[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++) {
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 && j ==0) {
                    matrix[i][j] =  true;
                }
                else {
                    matrix[i][j] = ( i - 1 >= 0 && matrix[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (j - 1 >= 0 && matrix[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}
