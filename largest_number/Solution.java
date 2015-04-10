public class Solution {
    public String largestNumber(int[] num) {
        if(num == null || num.length == 0) {
            return "";
        }
        merge_sort(num, 0, num.length -1);
        if(num[num.length - 1] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = num.length - 1; i >= 0; i--) {
            sb.append(Integer.toString(num[i]));
        }
        return sb.toString();
    }
    
    public void merge_sort(int[] num, int start, int end) {
        if(start >= end) {
            return;
        }
        int half = (end - start) / 2;
        merge_sort(num, start, start+ half);
        merge_sort(num, start + half + 1, end);
        int temp[] = new int[end - start + 1];
        int index_first = start;
        int index_second = start + half + 1;
        for(int i = 0; i < end - start + 1; i++) {
            if(index_first ==  start + half + 1) {
                temp[i] = num[index_second++];
            }
            else if(index_second == end + 1) {
                temp[i] = num[index_first++];
            }
            else if(lessthan_equalto(num[index_first], num[index_second])) {
                temp[i] = num[index_first++];
            }
            else {
                temp[i] = num[index_second++];
            }
        }
        for (int i = 0; i < end - start + 1; i++) {
            num[start + i] =  temp[i];
        }
    }
    
    public boolean lessthan_equalto(int num1, int num2) {
        if(num1 == num2) {
            return true;
        }
        int num1_str = Integer.toString(num1).length();
        int num2_str = Integer.toString(num2).length();
        if( num1 * Math.pow(10, num2_str) + num2 < num2 * Math.pow(10, num1_str) + num1) {
            return true;
        }
        return false;
    }

}
