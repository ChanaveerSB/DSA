package F3_Arrays.Medium;

import java.util.HashMap;

public class P3_MajorityEle {
    public static int majorityElement(int[] nums) {
        
        // Size of the given array
        int n = nums.length;
        
        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            
            // Counter to count occurrences of nums[i]
            int cnt = 0; 
            
            // Count the frequency of nums[i] in the array
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }
            
            // Check if frequency of nums[i] is greater than n/2
            if (cnt > (n / 2)) {
                // Return the majority element
                return nums[i]; 
            }
        }
        
        // Return -1 if no majority element is found
        return -1; 
    }

    public static int majorityElement2(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > arr.length / 2) {
                return num;
            }
        }

        return -1;
    }
    public static int majorityElement3(int[] arr){
        int t=-1,c=0;
        int l=arr.length;
        for(int i=0;i<l;i++){
            if(c==0){
                t=arr[i];
                c=1;
                continue;
            }
            else if(c>0) c++;
            else c--;
        }
        // //validate
        // int n=0;
        // for(int i=0;i<l;i++){
        //     if(t==arr[i]) n++;
        // }
        // if(n>l) return t;
        return t;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement2(arr));
        System.out.println(majorityElement3(arr));

    }
    
}