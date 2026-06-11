package F3_Arrays.F3_Hard;

import java.util.HashMap;
import java.util.Map;

public class P5_LongestSubArrLen {
    // Brute : nested for loop

    // Better : without key ie default check sum==0
    public static int longestSubArrLenBetter(int[] a) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (sum == 0) {
                maxLen = i + 1;
            } else if (sumIndexMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumIndexMap.get(sum));
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        return maxLen;
    }

    //Better 
    public static int longestSubArrLenOptimal(int[] arr, int n) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.containsKey(sum)) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    mpp.put(sum, i);
                }
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, -3, 3, -1, 6, -5 };

        System.out.println(longestSubArrLenBetter(arr));
        System.out.println(longestSubArrLenOptimal(arr, arr.length));
    }
}
