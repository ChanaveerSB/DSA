package DSA.Basics.Recursion;

import java.util.Scanner;

public class P3_Nto1Print {
    public static void func(int i,int n){
        if(i<n) return;

        System.out.println(i);

        func(i-1,n);
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number : ");
        func(sc.nextInt(),1);
        sc.close();
    }
    
}