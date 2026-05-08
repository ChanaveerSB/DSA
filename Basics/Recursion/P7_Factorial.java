package Basics.Recursion;
//Factorial of n numbers using recursion
public class P7_Factorial {
    //Method 1
    public static int func(int n){
        if(n==1) return 1;

        return n * func(n-1);
    }
    //Method 2
    public static void func1(int i,int fact){
        if(i==1){ 
            System.out.println(fact);
            return;
        }

        fact *= i;

        func1(i-1,fact);
    }
    public static void main(String[] args) {
        System.out.println(func(5));

        // func1(5,1);
    }
}
