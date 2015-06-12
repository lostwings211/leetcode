public class Solution {
    public String intToRoman_another(int num) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        
        String ret = "";
        int base = 1;
        while(num > 0) {
            int digit = num % 10;
            String curr = "";
            switch (digit) {
                case 1:
                    curr = map.get(base);
                    break;
                case 2:
                    curr = map.get(base) + map.get(base);
                    break;
                case 3:
                    curr = map.get(base) + map.get(base) + map.get(base);
                    break;
                case 4:
                    curr = map.get(base) + map.get(5 * base);
                    break;
                case 5: 
                    curr = map.get(5* base);
                    break;
                case 6:
                    curr = map.get(5 * base) + map.get(base);
                    break;
                case 7: 
                    curr = map.get(5 * base) + map.get(base) + map.get(base);
                    break;
                case 8: 
                    curr = map.get(5 * base) + map.get(base) + map.get(base) + map.get(base);
                    break;
                case 9:
                    curr = map.get(base) + map.get(10 * base);
                    break;
            }
            ret = curr + ret;
            num = num / 10;
            base = base * 10;
        }
        return ret;
    }
    
    public String intToRoman(int num) {
        String str = "";    
        String [] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
        int [] value = {1000, 900, 500, 400, 100, 90,  50, 40,  10, 9, 5, 4, 1};   
        int i = 0;
        while(num != 0) {  
            while(num >= value[i]) {  
                num -= value[i];  
                str = str + symbol[i];  
            }  
            i++;
        }  
        return str;  
    }
}
