package Basics.Maths;

public class P1_IsPrime {
        public static boolean isPrime(int n) {
        // Numbers less than or equal to 1 are not prime.
        if (n <= 1) {
            return false;
        }
 
        // 2 is the smallest prime number.
        if (n == 2) {
            return true;
        }
 
        // Any even number greater than 2 is not prime.
        if (n % 2 == 0) {
            return false;
        }
 
        // Check only odd divisors up to the square root of n.
        for (int i = 3; i * i <= n; i += 2) {
            // If a divisor is found, the number is not prime.
            if (n % i == 0) {
                return false;
            }
        }
 
        return true;
    }

    public static void main(String[] args) {
        // Solution sol = new Solution();
        int n = 25;
 
        if (isPrime(n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}








// n = 36  -->  sqrt(36) = 6

// Factor Pairs (a * b = 36):
//   1 * 36 = 36
//   2 * 18 = 36
//   3 * 12 = 36
//   4 *  9 = 36
//   6 *  6 = 36  <-- [i * i <= n] Boundary (sqrt(n))
// --------------------------------------------------
//   9 *  4 = 36  (Mirror: 4 already checked)
//  12 *  3 = 36  (Mirror: 3 already checked)
//  18 *  2 = 36  (Mirror: 2 already checked)
//  36 *  1 = 36  (Mirror: 1 already checked)
