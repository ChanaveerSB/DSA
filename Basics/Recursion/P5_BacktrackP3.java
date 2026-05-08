package Basics.Recursion;

public class P5_BacktrackP3 {
    public static void func(int i,int n){
        if(i>n) return;

        func(i+1,n);

        System.out.print(i+" ");
    }
    
    public static void func1(int curr,int m){
        if(curr>m) return;

        func1(curr+1,m);

        System.out.print(curr+" ");
    }

    public static void main(String[] args) {
        int n=10;
        func(1,n);
        System.out.print("\n-------------------------\n");
        int m=10;
        func1(1,m);
    }
}
