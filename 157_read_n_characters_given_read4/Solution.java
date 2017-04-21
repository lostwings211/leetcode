/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ret = 0;
        int i = 0;
        while(n > 0) {
            char[] temp = new char[4];
            int count = read4(temp);
            if(n < 4) {
                count = Integer.min(n, count);
            }
            for(int index = 0; index < count; index++) {
                buf[i++] = temp[index];
            }
            ret += count;
            n = n - 4;
        }
        return ret;
    }
}
