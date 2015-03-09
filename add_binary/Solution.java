public class Solution {
    public String addBinary(String a, String b) {
        //return  IntegertoBinary(BinarytoInteger(a) + BinarytoInteger(b));         
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        int carry_over = 0;
        StringBuilder sb = new StringBuilder();
        while(index_a >= 0 || index_b >= 0) {
            int curr_a = 0;
            int curr_b = 0;
            if(index_a >= 0)  {
                if(a.charAt(index_a) == '1') {
                    curr_a = 1;
                }
                index_a--;
            }
            if(index_b >= 0) {
                if(b.charAt(index_b) == '1') {
                    curr_b = 1;
                }
                index_b--;
            }
            sb.append((curr_a +  curr_b + carry_over) % 2);
            carry_over = (curr_a +  curr_b + carry_over) / 2;
        }
        if(carry_over > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
    
    public int BinarytoInteger(String input) {
        int ret = 0;
        int two_power = 1;
        if(input == null || input.length() == 0) {
            return ret;
        }
        for(int i = input.length() - 1; i >= 0; i--) {
            if(input.charAt(i) == '1') {
                ret += two_power;
            }
            two_power = two_power * 2;
        }
        return ret;
    }
    
    public String IntegertoBinary(int input) {
        StringBuilder sb = new StringBuilder();
        if(input == 0) {
            return "0";
        }
        while(input != 0) {
            int curr_digit = input % 2;
            if(curr_digit == 1) {
                sb.insert(0, '1');
            }
            else {
                sb.insert(0, '0');
            }
            input = input / 2;
        }
        return sb.toString();
    }
}
