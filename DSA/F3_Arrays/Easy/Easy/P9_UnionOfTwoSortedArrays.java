package Easy;

import java.util.Arrays;

public class P9_UnionOfTwoSortedArrays {
    public static int[] unionArray(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] temp = new int[n1 + n2];  // max possible size
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {

            int val;

            if (nums1[i] < nums2[j]) {
                val = nums1[i++];
            } 
            else if (nums2[j] < nums1[i]) {
                val = nums2[j++];
            } 
            else {
                val = nums1[i];
                i++;
                j++;
            }

            if (k == 0 || temp[k - 1] != val) {     //if k=0 allowed because next condition k-1 checks val
                temp[k++] = val;
            }
        }

        // Remaining elements of nums1
        while (i < n1) {
            if (k == 0 || temp[k - 1] != nums1[i]) {
                temp[k++] = nums1[i];
            }
            i++;
        }

        // Remaining elements of nums2
        while (j < n2) {
            if (k == 0 || temp[k - 1] != nums2[j]) {
                temp[k++] = nums2[j];
            }
            j++;
        }

        // Trim array to exact size
        int[] result = new int[k];
        for (int x = 0; x < k; x++) {
            result[x] = temp[x];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1={0,1,1,2,3,3,4,7,9};
        int[] nums2={0,2,3,4,5,5,6,8,8};

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        int[] result=unionArray(nums1 , nums2);
        System.out.println(Arrays.toString(result));

    }
}
