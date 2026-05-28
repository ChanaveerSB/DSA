package F3_Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class P6_Permutations {
    //Beginer
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        dfs(nums, visited, current, result);
        return result;
    }

    private static void dfs(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            current.add(nums[i]);

            dfs(nums, visited, current, result);

            current.remove(current.size() - 1); // backtrack
            visited[i] = false;
        }
    }

    //Bit high level
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
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
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //Main Method
    public static void main(String[] args) {
        int[] arr={1,2,3};

        List<List<Integer>> ans=permute(arr);
        List<List<Integer>> ans1=permute1(arr);

        System.out.println(ans);
        System.out.println(ans1);
        
    }
}
