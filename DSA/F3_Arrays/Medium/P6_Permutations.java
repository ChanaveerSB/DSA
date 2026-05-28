package F3_Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class P6_Permutations {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void backtrack(int[] nums, int index, List<List<Integer>> result) {
        // Base case: when index reaches end, store current permutation
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            result.add(perm);
            return;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);          // choose
            backtrack(nums, index + 1, result); // explore
            swap(nums, index, i);          // un-choose (backtrack)
        }
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};

        List<List<Integer>> ans=permute(arr);

        System.out.println(ans);
        
    }
}
