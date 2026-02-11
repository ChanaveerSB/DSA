package F3_Arrays;

import java.util.Arrays;
//array ranging from 0 to n
public class P10_MissingNumber {
    //optimal method
    public static int missingNumber(int[] nums) {
    int n = nums.length;
    int expected = n * (n + 1) / 2;
    int actual = 0;

    for(int num : nums){
        actual += num;
    }

    return expected - actual;

    }

    //normal method
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;

        // Iterate from 0 to n and check
        // if the current number is present
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            // If the current number is not present
            if (!found)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={5,3,7,4,2,1,0};
        // int[] nums={5,3,7,4,2,1,0,6};

        System.out.println(Arrays.toString(nums));
        System.out.println(missingNum(nums));   //normal
        System.out.println(missingNumber(nums));    //optimal

    }
}

