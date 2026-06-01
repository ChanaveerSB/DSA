package F3_Arrays.F2_Medium;

public class P2_SortArrOf0s1s2s {
    //Brute force method is using any efficient sorting method

    //Optimal
    // Function to sort the array containing only 0s, 1s and 2s
    public static void sortZeroOneTwo(int[] nums) {
        // Initialize count variables for 0s, 1s, and 2s
        int count0 = 0, count1 = 0, count2 = 0;

        // Count the frequency of 0s, 1s, and 2s
        for(int num : nums) {
            if(num == 0) count0++;
            else if(num == 1) count1++;
            else count2++;
        }

        // Overwrite the array with sorted values
        int index = 0;

        // Fill with 0s
        while(count0-- > 0) {
            nums[index++] = 0;
        }

        // Fill with 1s
        while(count1-- > 0) {
            nums[index++] = 1;
        }

        // Fill with 2s
        while(count2-- > 0) {
            nums[index++] = 2;
        }
    }

    
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0};

        P2_SortArrOf0s1s2s.sortZeroOneTwo(nums);

        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
