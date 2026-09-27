package Basics.Maths;

public class P2_CountPrimes {
    
    public static int countPrimesFaster(int n) {
        if (n <= 2) return 0;
        int cnt = n - 2;    //0 to n-1 assumed prime nums ie n prime nums, but we know 0 and 1 are never prime so n-2
        byte[] s = new byte[n]; 
        
        for (int i = 2; i * i < n; i++) {
            if (s[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    if (s[j] == 0) {
                        s[j] = 1;
                        cnt--;
                    }
                }
            }
        }
        return cnt;
    }

    public static int countPrimes(int n) {
        if (n <= 2) return 0;

        // isPrime[i] is true if i is prime.
        // Default boolean in Java is false, so we use an array where false = prime
        // or boolean array where true = composite.
        boolean[] isComposite = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
                
                // Mark multiples of i starting from i * i
                // Use (long) to prevent 32-bit integer overflow when i * i > 2^31 - 1
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int count=countPrimesFaster(50000);
        // int count=countPrimes(50000);

        System.out.println(count);
    }
}
