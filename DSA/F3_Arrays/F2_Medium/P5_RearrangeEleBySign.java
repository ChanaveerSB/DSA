package F3_Arrays.F2_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P5_RearrangeEleBySign {
    // BruteForce (EQUAL no of +ve and -ve elements in arr)
    public static int[] rearrangeArrElesBySign(int[] arr) {
        int len = arr.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        for (int i = 0; i < len / 2; i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }

        return arr;
    }

    // Optimal (EQUAL no of +ve and -ve elements in arr)
    public static int[] rearrangeArrElesBySign1(int[] arr) {
        int p = 0, n = 1;
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ans[p] = arr[i];
                p += 2;
            } else {
                ans[n] = arr[i];
                n += 2;
            }
        }

        return ans;
    }

    // Optimal is not possible without equal +ve and -ve no of arr elements
    // So BruteForce (due to NOT-EQUAL no of +ve and -ve elements in arr)
    public static int[] rearrangeArrElesBySign2(int[] arr) {
        int len = arr.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        int p = pos.size(), n = neg.size();
        if (p > n) {
            for (int i = 0; i < n; i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int ind = n * 2;
            for (int i = n; i < p; i++) {
                arr[ind++] = pos.get(i);
            }
        } else {
            for (int i = 0; i < p; i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int ind = p * 2;
            for (int i = p; i < n; i++) {
                arr[ind++] = neg.get(i);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        // Number of +ve and -ve elements are Equal
        int[] arr = { 3, 1, -2, -5, 2, -4 };

        System.out.println(Arrays.toString(rearrangeArrElesBySign(arr)));
        System.out.println(Arrays.toString(rearrangeArrElesBySign1(arr)));

        System.out.println();

        // Number of +ve and -ve elements are Not-Equal
        int[] arr1 = { 3, 1, -2, -5, 2, 4 };

        System.out.println(Arrays.toString(rearrangeArrElesBySign2(arr1)));

    }
}