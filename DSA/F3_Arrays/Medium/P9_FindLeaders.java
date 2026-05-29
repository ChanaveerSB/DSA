package F3_Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class P9_FindLeaders {
    //Brute
    public List<Integer> leaders(int[] nums) {
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            // Check all elements to the right
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                li.add(nums[i]);
            }
        }
        return li;
    }

    //Optimal
    public static List<Integer> leaders1(int[] nums) {
        List<Integer> li = new ArrayList<>();
        int len = nums.length;
        int max = nums[len - 1];

        li.add(max);
        // Traverse from right to left
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                li.add(max);
            }
        }

        // Reverse list
        int i = 0;
        int j = li.size() - 1;
        
        while (i < j) {
            int temp = li.get(i);
            li.set(i, li.get(j));
            li.set(j, temp);
            i++;
            j--;
        }
        return li;
    }

    public static void main(String[] args) {
        int[] arr={10,22,9,3,6,0,2};

        System.out.println(leaders1(arr));
        System.out.println(leaders1(arr));
    }

}
