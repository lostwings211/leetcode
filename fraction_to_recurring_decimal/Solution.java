import java.util.*;
public class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long, Integer> visit = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0  && denominator > 0)) {
            sb.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        sb.append(Long.toString(numerator/denominator).replace("-", ""));

        long remainder = (long) numerator % (long)denominator;
        if(remainder != 0) {
            sb.append('.');
            int start_index =  sb.length();

            while(remainder != 0) {
                System.out.println(remainder);
                if(!visit.containsKey(remainder)) {
                    visit.put((long)remainder, start_index);
                    long result = (10 * remainder) / denominator;
                    remainder = (10 * remainder) % denominator;
                    sb.append(Long.toString(result).replace("-", ""));
                    start_index++;
                }
                else {
                    int prev_index = visit.get(remainder);
                    sb.insert(prev_index, '(');
                    sb.append(')');
                    break;
                }
            }
        }
        return sb.toString();
    }

}
