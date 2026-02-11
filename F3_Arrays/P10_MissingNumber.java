package F3_Arrays;

import java.util.Arrays;

public class P10_MissingNumber {
    public static int missingNumber(int[] nums) {
    int n = nums.length;
    int expected = n * (n + 1) / 2;
    int actual = 0;

    for(int num : nums){
        actual += num;
    }

    return expected - actual;

    }

    public static void main(String[] args) {
        int[] nums={5,3,7,4,2,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(missingNumber(nums));
    }
}

