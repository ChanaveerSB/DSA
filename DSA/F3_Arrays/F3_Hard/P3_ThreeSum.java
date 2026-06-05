package F3_Arrays.F3_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P3_ThreeSum {
//Brute
public static List<List<Integer>> threeSumBrute(int[] nums) {
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
public static List<List<Integer>> threeSumHash(int[] nums) {
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


    //Optimal (2 pointer) //32:08
    public static List<List<Integer>> threeSumPointer(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            //i should'nt increment when in first index so i>0 it can increment only after j>k (video : 32:08) then compare with next ele to move next unique element from previous 
            if(i>0 && nums[i]==nums[i-1]) continue; //continue becoz for will however increments
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                } 
                else{
                    // List<Integer> li=new ArrayList<>(List.of(nums[i],nums[j],nums[k]));
                    //ans.add(li);
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    //to get other combinations with unique j and k that their previous position elements
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4, 3, -2, -3, 4};

        System.out.println(threeSumBrute(nums));
        System.out.println(threeSumHash(nums));
        System.out.println(threeSumPointer(nums));
    }
}
