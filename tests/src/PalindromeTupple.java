import java.io.*;
import java.util.*;

public class PalindromeTupple {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        //Scanner in = new Scanner(System.in);
        //String s = in.next();

        String s="ghhggh";
        int sum=0;
        for(int i =0;i<s.length();i++){
           sum = sum+findTupple(s.substring(i), "", i);
           System.out.println("sdfsdfsdfsdfsdfsdfsfsdfsd");

        }
        System.out.println(sum);
    }

    private static int findTupple(String s , String s2, int n){
        System.out.println(s2);
       // if(s2.length() > 4) return 0;
        if(s2.length() == 4){
            if(isPlaindrome(s2)){
                System.out.println("Palindrome: "+s2);

                return 1;
            }
            return 0;
        }
        int sum=0;
            for(int i =n;i<s.length();i++){
               // System.out.println("s2 = "+s2+" new char = "+s.substring(i,i+1));
               // System.out.println(s2);
               s2.concat(s.substring(i,i+1));
                //System.out.println(s2);

                int k = findTupple(s,s2.concat(s.substring(i,i+1)),i+1);
               // if( k > 0){
                //    System.out.print("n = "+n+" i = "+i+" ");
                   // System.out.println("s2 = "+s2+" new char = "+s.substring(i,i+1));

               // }
                sum = sum + k;
            }
        return sum;
    }
    private static boolean isPlaindrome(String s){
        if(s.charAt(0)==s.charAt(3) && s.charAt(1) == s.charAt(2)) return true;
        return false;
    }
}