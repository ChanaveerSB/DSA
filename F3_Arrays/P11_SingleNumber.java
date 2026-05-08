package F3_Arrays;

public class P11_SingleNumber {
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,4,4,5,5};

        System.out.println(singleNumber(arr));
    }
}
