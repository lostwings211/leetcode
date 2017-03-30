public class Solution {
    public static String complexNumberMultiply(String a, String b) {
        List<Integer> ret_a = parse(a);
        List<Integer> ret_b = parse(b);
        int c_a = ret_a.get(0);
        int k_a = ret_a.get(1);
        int c_b = ret_b.get(0);
        int k_b = ret_b.get(1);
        
        int c_new = k_a * k_b * -1 + c_a * c_b;
        int k_new = c_a * k_b + k_a * c_b;
        
        String s = Integer.toString(c_new) + "+" + Integer.toString(k_new) + "i";
        return s;
    }
    
    public static List<Integer> parse(String s) {
        List<Integer> ret = new ArrayList<Integer>();
        int start = 0;
        int index = 0;
        while(index < s.length() && s.charAt(index) != '+') {
            index++;
        }
        if(index == s.length()) {
            ret.add(Integer.MIN_VALUE);
            ret.add(Integer.MIN_VALUE);
            return ret;
        }
        ret.add(Integer.parseInt(s.substring(start, index)));
        
        index++;
        start = index;
        while(index < s.length() && s.charAt(index) != 'i') {
            index++;
        }
        if(index == s.length()) {
            ret.add(Integer.MIN_VALUE);
            return ret;
        }
        ret.add(Integer.parseInt(s.substring(start, index)));
        return ret;
    }
}
