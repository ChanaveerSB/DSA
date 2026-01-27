package Basics.Recursion;

public class P6_SumOfNnums {
    //Method 1
    public static int func(int n){
        if(n==1) return 1;

        return n + func(n-1);
    }
    //Method 2
    public static void func1(int i,int sum){
        if(i==0){
            System.out.println(sum);
            return;
        }

        sum+=i;

        func1(i-1, sum);
    }
    public static void main(String[] args) {
        //sum of 9 serial numbers
        System.out.println(func(9));

        func1(9,0);
    }
}
