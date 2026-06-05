package F3_Arrays.F3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P4_FourSum {
    //Brute:
    public static List<List<Integer>> fourSumBrute(int[] arr, int target) {
        int n = arr.length;
        // Use set to avoid duplicate quadruplets
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        // Use a larger data type (like long) when combining multiple int values to avoid overflow, since the sum or difference can exceed the int range.
                        long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target) {
                            // Create quadruplet
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            // Sort to maintain uniqueness
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        // Convert set to list and return
        return new ArrayList<>(set);
    }

    //Better:
        public static List<List<Integer>> fourSumBetter(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // HashSet for numbers between j and k
                HashSet<Integer> seen = new HashSet<>();

                for (int k = j + 1; k < n; k++) {
                    // Use a larger data type (like long) when combining multiple int values to avoid overflow, since the sum or difference can exceed the int range.
                    long required = (long) target - arr[i] - arr[j] - arr[k];

                    // If required number already seen → valid quadruplet
                    if (seen.contains((int) required)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], (int) required);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    // Add current third number into set
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
    
    //Optimal:


    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(fourSumBrute(arr, target));
        System.out.println(fourSumBetter(arr, target));

    }

}
