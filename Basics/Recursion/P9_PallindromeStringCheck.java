package DSA.Basics.Recursion;

public class P9_PallindromeStringCheck {
    public static boolean isPallindrome(String s,int i,int j){
        if(i>=j) return true;
        if(s.charAt(i)!=s.charAt(j)) return false;
        return isPallindrome(s,i+1,j-1);
    }
    public static void main(String[] args) {
        String s1="civic";
        String s2="Bestest";

        System.out.println(isPallindrome(s1,0,s1.length()-1));
        System.out.println(isPallindrome(s2,0,s2.length()-1));
    
    }
}
