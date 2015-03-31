public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, j = 0;
        int sum = 0;
        int total = 0;
        while (j < gas.length) {
            int diff = gas[j] - cost[j];
            if (sum + diff < 0) {
                i = j + 1;
                sum = 0;
            } 
            else {
                sum += diff;
            }
            j++;
            total += diff;
        }
        return total >= 0 ? i : -1;
    }
}
