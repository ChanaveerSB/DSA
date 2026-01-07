package DSA.Basics.Recursion;

public class P5_BacktrackP3 {
    public static void func(int i,int n){
        if(i>n) return;

        func(i+1,n);

        System.out.println(i);
    }
    
    public static void func1(int m){
        if(m==0) return;

        func1(m-1);

        System.out.println(m);
    }

    public static void main(String[] args) {
        int n=10;
        func(1,n);
        System.out.println("-------------------------");
        int m=10;
        func1(m);
    }
}
