package Basics.Hashing;

import java.util.HashMap;
import java.util.Map;

public class P2_HighestFrequency {
        public static int mostFrequentElement(int[] nums) {
        int n = nums.length;
        int maxFreq=0, maxEle=0;
        
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i]) continue;

            int freq = 0;

            for(int j=i;j<n;j++){
                if(nums[i]==nums[j]){
                    freq++;
                    visited[i]=true;
                }
            }

            if(freq > maxFreq){
                maxFreq=freq;
                maxEle=nums[i];
            }
            else if(freq == maxFreq){
                maxEle = Math.min(maxEle, nums[i]);
            }
        }

        return maxEle;
    }

    public static void countFrequencies(int[] nums) {
        Map<Integer,Integer> freq=new HashMap<>();

        for(int n : nums){
            freq.put(n , freq.getOrDefault(n, 0) + 1);
        }

        int maxFreq=Integer.MIN_VALUE, maxFreqEle=Integer.MIN_VALUE, minFreq=Integer.MAX_VALUE, minFreqEle=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(entry.getValue() > maxFreq){
                maxFreq = entry.getValue();
                maxFreqEle = entry.getKey();
            }
            else if(entry.getValue() < minFreq){
                minFreq = entry.getValue();
                minFreqEle = entry.getKey();
            }
            else{
                // Math.min(maxFreqEle , entry.getKey());
                // Math.max(minFreqEle , entry.getKey());
            }

        }
    
        System.out.println(maxFreqEle +" and "+ minFreqEle ); 

    }

    public static void main(String[] args) {
        int[] arr = {3,3,5,2,3,5,2,4,7,2,9};

        countFrequencies(arr);

        System.out.println(mostFrequentElement(arr));
    }
}



