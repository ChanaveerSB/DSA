package F3_Arrays;

import java.util.Arrays;

public class P3_RemoveDuplicateEles {
    public static int removeDuplicates(int[] nums) {
        int n=nums.length;
        int[] t= new int[n];
        int ind=0;
        int i=0;
        // int temp=nums[i];
            int j=i+1;
            while(j<n){
                if(nums[i]!=nums[j]){
                    nums[++i]=nums[j];
                    ind++;
                }
                j++;
            }
            

            // nums=t;

            return ind+1;
        
    }

    public static void main(String[] args) {
        int[] arr={0, 0, 3, 3, 5, 6};

        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

    }
}
