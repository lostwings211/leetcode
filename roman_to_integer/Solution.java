public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ret = 0;
        int i = 0;
        while(i < s.length()) {
            if(i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                ret += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i += 2;
            }
            else {
                ret += map.get(s.charAt(i));
                i += 1;
            }
        }
        return ret;
    }
}
