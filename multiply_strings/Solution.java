public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        String sum = "0";

        for(int j = length2 -1; j >= 0; j--) {
            StringBuilder curr_passproduct = new StringBuilder();
            int carry_over =  0;
            int curr_num2 = num2.charAt(j) - '0';
            for(int i = length1 -1; i >= 0; i--) {
                int curr_num1 = num1.charAt(i) - '0';
                int curr_product = curr_num2 * curr_num1 + carry_over;
                curr_passproduct.insert(0, curr_product % 10);
                carry_over = curr_product / 10;
            }
            if(carry_over > 0) {
                curr_passproduct.insert(0, carry_over);
            }

            int k = j;
            while (k < length2 -1) {
                curr_passproduct.append('0');
                k++;
            }
            sum = addition(sum, curr_passproduct.toString());
        }
        return sum;
    }
    
    public String addition(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int max_length = length1 >= length2 ? length1 : length2;
        int i = 0;
        StringBuilder sb = new StringBuilder();

        int carry_over = 0;
        while(i < max_length) {
            int curr_num1 = 0;
            if(length1 - 1 - i >= 0) {
                curr_num1 = num1.charAt(length1 - 1 - i) - '0';
            }
            int curr_num2 = 0;
            if(length2 -1 - i >= 0) {
                curr_num2 = num2.charAt(length2 - 1 - i) - '0';
            }

            int curr_sum =  curr_num1 + curr_num2 + carry_over;
            sb.insert(0, curr_sum % 10);
            carry_over = curr_sum / 10;
            i++;
        }
        if (carry_over > 0) {
            sb.insert(0, carry_over);
        }
        return sb.toString();
    }
}
