package DSA.F3_Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class P1_TwoSum {

    // Brute Force Approach
    static void brute(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {
                    System.out.println("Brute Force:");
                    System.out.println("Indices: " + i + " , " + j);
                    return;
                }
            }
        }

        System.out.println("No Pair Found");
    }

    // Better Approach using HashMap
    static void better(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            if (map.containsKey(complement)) {

                System.out.println("Better Approach:");
                System.out.println("Indices: "
                        + map.get(complement) + " , " + i);
                return;
            }

            map.put(arr[i], i);
        }

        System.out.println("No Pair Found");
    }

    // Optimal Approach using Two Pointer
    static void optimal(int[] arr, int target) {

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {

                System.out.println("Optimal Approach:");
                System.out.println("Pair: "
                        + arr[left] + " , " + arr[right]);
                return;
            }

            else if (sum < target) {
                left++;
            }

            else {
                right--;
            }
        }

        System.out.println("No Pair Found");
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        brute(arr, target);
        better(arr, target);
        optimal(arr, target);
    }
}
