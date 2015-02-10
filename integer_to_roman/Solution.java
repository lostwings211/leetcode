public class Solution {
    public static class Tuple {
        public final String symbol;
        public final int value;
        
        public Tuple (String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }

    public static String intToRoman(int num) {
        String result = "";
        // Given the assumption that input is guaranteed to be between 1 to 3999
        if(num < 1 || num > 3999) {
            return result;
        }
        Tuple[] tuples = new Tuple[] {
                                        new Tuple("I", 1), 
                                        new Tuple("V", 5), 
                                        new Tuple("X", 10),
                                        new Tuple("L", 50), 
                                        new Tuple("C", 100), 
                                        new Tuple("D", 500),
                                        new Tuple("M", 1000)
                                     };

        int digits = 0;
        while (num > 0) {
            String curr_symbol = "";
            int remainder = num % 10;
            switch (remainder) {
                case 0:
                case 1: 
                case 2:
                case 3:
                    for(int i = 0; i < remainder; i++) {
                        curr_symbol = curr_symbol + tuples[digits].symbol;
                    }
                    break;
                case 4:
                    curr_symbol = tuples[digits].symbol + tuples[digits+1].symbol;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    curr_symbol = tuples[digits+1].symbol;
                    for(int i = 0; i < remainder - 5; i++) {
                        curr_symbol = curr_symbol + tuples[digits].symbol;
                    }
                    break;
                case 9:
                    curr_symbol = tuples[digits].symbol + tuples[digits+2].symbol;
                    break;    
            }
            result = curr_symbol + result;
            num = num / 10;
            digits = digits+2;
        }     
        return result;
    }
}
