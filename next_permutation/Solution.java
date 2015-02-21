public class Solution {
    public void nextPermutation(int[] num) {
        if(num == null || num.length == 0) return;
        for(int i = num.length - 1; i > 0; i--) {
            if(num[i] > num[i-1]) {
                for(int j = num.length - 1; j >=i; j--) {
                    if(num[i-1] < num[j]) {
                        int temp = num[i-1];
                        num[i-1] = num[j];
                        num[j] = temp;
                       
                        for(int k = 0; k < (num.length - i) / 2 ; k++) {
                            int temp_1 = num[i+k];
                            num[i+k] = num[num.length - 1 -k];
                            num[num.length -1 -k] = temp_1;
                        }
                        return;
                    }
                }
            }
        }

        for(int i = 0; i < num.length / 2 ; i++) {
            int temp =  num[i];
            num[i] = num[num.length-1-i];
            num[num.length-1-i] = temp;
        }
    }
}
