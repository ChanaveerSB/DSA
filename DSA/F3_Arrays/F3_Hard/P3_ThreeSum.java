package F3_Arrays.F3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P3_ThreeSum {
//Brute
public List<List<Integer>> threeSumBrute(int[] nums) {
    int n = nums.length;
    Set<List<Integer>> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(triplet); // normalize order
                    set.add(triplet);          // no duplicates
                }
            }
        }
    }
    return new ArrayList<>(set);
}

//Better
public List<List<Integer>> threeSumHash(int[] nums) {
    int n = nums.length;
    Set<List<Integer>> res = new HashSet<>();
    
    for (int i = 0; i < n; i++) {
        Set<Integer> seen = new HashSet<>();
        for (int j = i + 1; j < n; j++) {
            int target = -nums[i] - nums[j];
            if (seen.contains(target)) {
                List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
                Collections.sort(triplet);
                res.add(triplet);
            }
            seen.add(nums[j]);
        }
    }
    return new ArrayList<>(res);
}


}
