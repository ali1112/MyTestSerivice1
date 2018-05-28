import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner in = new Scanner(System.in);
        String numbers = in.nextLine();
        String tokens[] = numbers.split(" ");
        Integer [] intArray= new Integer[tokens.length];
        int i =0;
        if(tokens.length > 0){
            try{
                for(int k=0; k <tokens.length;k++ ){
                    int num = Integer.parseInt(tokens[k]);
                    intArray[k] = num;
                }


            }
            catch(Exception e){
                throw new Exception();
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        if(intArray.length > 0){
            list.add(intArray[0]);

        }
        if(intArray.length > 1){

            for (int j =1; j < intArray.length; j++ ){
                int diff = intArray[j] - intArray[j-1];
                if(Math.abs(intArray[j] - intArray[j-1]) > 127){
                        list.add(-128);
                        list.add(diff);
                }
                else{
                    list.add(diff);

                }
            }
        }

        for(Integer inValue:list){
            System.out.print(inValue+" ");
        }

    }
}