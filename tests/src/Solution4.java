import java.io.*;
import java.util.*;

public class Solution4 {
    public static void main(String args[] ) throws Exception {

        Scanner in = new Scanner(System.in);

        int other = 0;
        int square = 0;
        int rect = 0;

        while(in.hasNext()){

            String line = in.nextLine();
            String [] tokens = line.split(" ");
            Integer a = null;
            Integer b = null;
            Integer c = null;
            Integer d = null;
            /*if(tokens.length < 0 || tokens.length > 4){
                return ;
            }*/
            try{
                a = Integer.parseInt(tokens[0]);
                b = Integer.parseInt(tokens[1]);
                c = Integer.parseInt(tokens[2]);
                d = Integer.parseInt(tokens[3]);
            }
            catch(Exception e){
                throw new Exception();
            }


            if(a < 0 || b < 0 | c <0 | d < 0){
                other++;
            }
            else if((a ==c && b == d) && (a != b)){
                rect++;
            }
            else if (a==b && b==c && c ==d && d==a){
                square++;
            }
            else{
                other++;
            }


        }
        System.out.println(square+" "+rect+" "+other);

    }
}