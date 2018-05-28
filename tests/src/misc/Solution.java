package misc;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k =0;
        if(s == null || s.equals("")){
            System.out.println(0);
            return;
        }
        
        k++;
        for(int i =0 ; i < s.length(); i++){
            int asciiValue= s.charAt(i);
            // System.out.println(k);
            // System.out.println(s.charAt(i));

            if( asciiValue >= 65 &&  asciiValue <=90){
                k++;
            }
            
         
            
         
        }
        System.out.println(k);

    }
    
    
}
