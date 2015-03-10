public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length== 0) {
            return digits;
        }
        StringBuilder sb = new StringBuilder();
        int carry_over = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int curr_digit = digits[i];
            sb.append((curr_digit + carry_over) % 10);
            carry_over = (curr_digit + carry_over) / 10;
        }
        if(carry_over == 1) {
            sb.append(carry_over);
        }
        String result_string = sb.reverse().toString();
        int result[] = new int[result_string.length()];
        for(int i = 0; i < result_string.length(); i++) {
            result[i] = result_string.charAt(i) - '0';
        }
        return result;
    }
}
