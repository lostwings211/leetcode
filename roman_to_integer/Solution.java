public class Solution {
    public int convert(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000; 
        }
        return 0;
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] char_array = s.toCharArray();
        int index = 0;
        int length = char_array.length;
        while (index < length) {
            char curr_symbol = char_array[index];
            int curr_val = convert(curr_symbol);
            if((curr_symbol == 'I' || curr_symbol == 'X' || curr_symbol == 'C') 
                && index + 1 < length) {
                char next_symbol = char_array[index + 1];
                int next_val = convert(next_symbol);
                if (curr_val < next_val) {
                    result += (next_val - curr_val);
                    index = index + 2;
                    continue;
                }   
            }
            result += curr_val;
            index++;
        } 
        return result;
    }
}   
