package Basics.Recursion;

public class P1_Name5Times {
    public static void func(int i,int n){
        if(i>5) return;

        System.out.println("Veer");

        func(i+1,n);
    }
    public static void main(String[] args) {
        
        func(1,5);
        
    }
    
}