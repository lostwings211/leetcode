public class Solution {
	public static String longestPalindrome_advanced(String s) {
		if(s == null || s.length() <= 0 ) {
            return "";
        }

        int[] indexes = new int[2];
		int length = s.length();        
		boolean [][] map =  new boolean[length][length];
		for (int i = 0; i < length; i++) {
			map[i][i] = true;
		}
		
		for(int i = length - 1; i > 0; i--) {
			for(int j = i + 1; j < length; j++) {
				if(j-i == 1) {
					map[i][j] = (s.charAt(i) == s.charAt(j));
				}
				else if( map[i+1][j-1] == true && s.charAt(i) == s.charAt(j)) {
					map[i][j] = true;
				}
				else {
					map[i][j] = false;
				}
				
				if(map[i][j] == true && ((j -i) > indexes[1] - indexes[0])) {
					indexes[0] = i;
					indexes[1] = j;
				}
				System.out.format("(%d, %d): %b\n", i, j, map[i][j]);
			}
		}
		String result = s.substring(indexes[0], indexes[1] + 1);
		return result;
	}

	public static String longestPalindrome(String s) {
		String result = "";
		return result;
	}

	public static void main(String[] args) {
		String input = "abacdfgdcaba";
		String result = longestPalindrome_advanced(input);
		System.out.println(result);
	}
}
