package F3_Arrays.F2_Medium;

import java.util.HashMap;
import java.util.Map;

public class P14_CountSubArrSumK {
    // Brute
    public static int countSubArrOfSumK(int[] nums, int k) {
        int n = nums.length;

        int sum;
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int a = i; a <= j; a++) {
                    sum = sum + nums[a];
                }
                if (sum == k) {
                    c++;
                }
            }
        }

        return c;
    }

    // Better
    public static int countSubArrOfSumK1(int[] nums, int k) {
        int n = nums.length;

        int sum;
        int c = 0;

        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    c++;
                }
            }
        }

        return c;
    }

    // Optimal
    public static int countSubArrOfSumK2(int[] arr, int k) {
        Map<Integer, Integer> h = new HashMap<>();
        int preSum = 0;
        int count = 0;

        h.put(0, 1); // base case
        // The base case ensures that subarrays starting at index 0 are counted
        // correctly when the running prefix sum itself equals k

        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];

            int rem = preSum - k;
            if (h.containsKey(rem))
                count += h.get(rem);

            h.put(preSum, h.getOrDefault(preSum, 0) + 1); // 1 because for adding coount += h.get(rem)

        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1, 2, 3, -2, 4 };
        int k = 3;

        System.out.println(countSubArrOfSumK(arr, k));
        System.out.println(countSubArrOfSumK1(arr, k));
        System.out.println(countSubArrOfSumK2(arr, k));

    }
}