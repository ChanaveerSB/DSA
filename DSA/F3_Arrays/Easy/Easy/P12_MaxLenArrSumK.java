package Easy;

import java.util.HashMap;
import java.util.Map;

public class P12_MaxLenArrSumK {
    // optimal method
    public static int longestSubarrayOptimal(int[] nums, int k) {
        int n = nums.length;

        // To store the maximum length of the subarray
        int maxLen = 0;

        // Pointers for sliding window
        int left = 0, right = 0;

        // Sum of the current window
        int sum = nums[0];

        // Traverse through the array
        while (right < n) {

            // Shrink the window if sum exceeds k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // Update max length if sum equals k
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Expand the window to the right
            right++;
            if (right < n) {
                sum += nums[right];
            }

        }

        return maxLen;
    }

    // Better method
    public static int maxLen(int[] A, int K) {
        int n=A.length;

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;    //to store sum till the current index values
        int maxi = 0;   //to store max length of arr

        for (int i = 0; i < n; i++) {

            sum += A[i];

            // if subarray from 0 to i itself gives K
            if (sum == K) {
                maxi = i + 1;
            }

            // check if (sum-K) existed before
            if (map.containsKey(sum - K)) {

                maxi = Math.max(maxi, i - map.get(sum - K));
            }

            // store first occurrence only
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxi;
    }

    // Brute method
    public static int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int sum;
        int max = 0; // max lenght of array whose sum is k

        // start index subarray always between 0 to n
        for (int i = 0; i < n; i++) {
            // end index of subarray always between **i** to n
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int a = i; a <= j; a++) {
                    sum = sum + nums[a];
                }
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    //mine
    public static int demo(int[] A, int K){
        int l=0,s=0;
        Map<Integer,Integer> h=new HashMap<>();

        for(int i=0;i<A.length;i++){
            s+=A[i];
            int t=s-K;
            if(h.containsKey(t)){
                l=Math.max(l, i-h.get(t));
            }

            //We do not overwrite the existing prefix sum because keeping the earliest occurrence helps achieve the maximum possible subarray length.
            if(!h.containsKey(t))    h.put(s,i);
            //eg : [2 0 0 3] after put(2,0) we dont wanna override increase index(due to same key 0s) which will reduce maxlen
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = { -10, -2, 5, 2, 7, 1, -1, 9 };
        int k = 15;

        // System.out.println(longestSubarray(arr, k));
        // System.out.println(maxLen(arr, k));

        // below only applicable if positive values r in array
        // System.out.println(longestSubarrayOptimal(arr, k));

        //mine below
        System.out.println(demo(arr, k));
    }
}
