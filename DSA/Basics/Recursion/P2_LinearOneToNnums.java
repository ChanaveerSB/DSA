package Basics.Recursion;

import java.util.Scanner;

public class P2_LinearOneToNnums {
    public static void func(int i,int n){
        if(i>n) return;

        System.out.println(i);

        func(i+1,n);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number : ");
        func(1,sc.nextInt());

        sc.close();
    }
}
