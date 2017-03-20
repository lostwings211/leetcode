public class Solution {
    public int countPrimes(int n) {
        if(n <= 1) {
            return 0;
        }
        boolean[] primes = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            primes[i] = true;
        }
        primes[0] =  false;
        primes[1] =  false;
        
        for(int index = 2; index < n; index++) {
            for(int i = index + index; i <= n; i += index){
                primes[i] = false;
            }
        }
        
        int count = 0;
        for(int i = 1; i < n; i++) {
            if(primes[i] == true) {
                count++;
            }
        }
        return count;
        
    }
    
    public int countPrimes_slow(int n) {
        if(n <= 2) {
            return 0;
        }
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3; i < n; i++) {
            boolean isPrime = true;
            for(int j = 0; j < primes.size(); j++) {
                if(i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime == true) {
                primes.add(i);
            }
        }   
        return primes.size();
    }
}
