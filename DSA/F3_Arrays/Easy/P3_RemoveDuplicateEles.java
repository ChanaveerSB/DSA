package F3_Arrays.Easy;

import java.util.Arrays;

//In SORTED array only method
public class P3_RemoveDuplicateEles {
    public static int removeDuplicates(int[] nums) {
        int n=nums.length;

        int i=0;
 
        for(int j=1;j<n;j++){
            if(nums[i] != nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }  

        return i+1;
        
    }

    public static void main(String[] args) {
        int[] arr={0, 0, 3, 3, 5, 6};

        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));

    }
}
