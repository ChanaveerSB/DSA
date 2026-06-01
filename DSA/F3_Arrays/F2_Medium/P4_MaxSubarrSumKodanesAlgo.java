package F3_Arrays.F2_Medium;

import java.util.Arrays;

public class P4_MaxSubarrSumKodanesAlgo {
    // BruteForce
    public static int maxSubarrSum(int[] nums) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {

                int sum = 0;

                // Calculate the sum of subarray nums[i...j]
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                // maxi = Math.max(maxi, sum); //This method takes more time
                if (sum > maxi)
                    maxi = sum;
            }
        }

        return maxi;
    }

    // Better
    public static int maxSubarrSum2(int[] nums) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                // maxi = Math.max(maxi, sum); //This method takes more time
                if (sum > maxi)
                    maxi = sum;

            }
        }

        return maxi;
    }

    // Optimal (Kodane's Algo)
    public static int maxSubarrSum3(int[] arr) {
        int max = Integer.MIN_VALUE; // If max=0 , when all elements are -ve then it will return 0 
                                     // rather than returning -ve value. So used Integer.MIN_VALUE
        int sum = 0;

        for (int i : arr) {
            sum += i;

            // max = Math.max(max, sum); //This method takes more time
            if (sum > max)
                max = sum;

            if (sum < 0)
                sum = 0;
        }
        return max;
    }

    public static int[] maxSubarrSumArr(int[] arr) {
        int max = Integer.MIN_VALUE; // If max=0 , when all elements are -ve then it will return 0 rather than
                                     // returning -ve value. So used Integer.MIN_VALUE
        int sum = 0;
        int si = -1, ei = -1;
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0)
                s = i;

            sum += arr[i];

            // max = Math.max(max, sum);
            if (sum > max) {
                max = sum;
                si = s;
                ei = i;
            }

            if (sum < 0)
                sum = 0;
        }

        int[] temp = new int[ei - si + 1];
        int in = 0;
        for (int i = si; i <= ei; i++) {
            temp[in++] = arr[i];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

        System.out.println(maxSubarrSum(arr));
        System.out.println(maxSubarrSum2(arr));
        System.out.println(maxSubarrSum3(arr));
        // gives max sub array elements
        System.out.println(Arrays.toString(maxSubarrSumArr(arr)));
    }
}