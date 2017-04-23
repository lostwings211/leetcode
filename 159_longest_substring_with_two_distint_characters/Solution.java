public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2) {
            return s.length();
        }
        int ret = 2;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 0);
        map.put(s.charAt(1), 0);
        int start = 0;
        int i = 2;
        while(i < s.length()) {
            map.put(s.charAt(i), 0);
            if(map.size() <= 2) {
                if(i - start + 1 > ret) {
                    ret = i - start + 1;
                }
            }
            else {
                int prev = i - 1;
                while(prev - 1 >= 0 && s.charAt(prev - 1) == s.charAt(prev)) {
                    prev--;
                }
                start = prev;
                map.remove(s.charAt(prev-1));
            }
            i++;
        }
        return ret;
    }
}
