package Basics.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1_Frequency {
    public static List<List<Integer>> countFrequencies(int[] nums) {
        Map<Integer,Integer> freq=new HashMap<>();

        for(int n : nums){
            freq.put(n , freq.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> res=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            res.add(Arrays.asList( entry.getKey() , entry.getValue() ));
        }
    
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {3,3,5,2,3,5,2,4,7,2,9};

        List<List<Integer>> result = countFrequencies(arr);

        System.out.println(result);
    }
}
