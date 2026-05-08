package Basics.Recursion;

public class P4_BacktrackP2 {
    public static void func(int i,int n){
        if(i<n) return;
        // int i=n; //not needed as n value is decreased by 1 in next func not in this as n!=n-1 ie n-1 only
        func(i-1,n);

        System.out.println(i);
        
    }
    public static void main(String[] args) {
        int i=9;
        func(i,1);
    }
    // public static void func(int n){
    //     if(n<1) return;
    //     // int i=n; //not needed as n value is decreased by 1 in next func not in this as n!=n-1 ie n-1 only
    //     func(n-1);

    //     System.out.println(n);
        
    // }
    // public static void main(String[] args) {
    //     int n=9;
    //     func(n);
    // }
}
