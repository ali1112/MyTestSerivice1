package misc;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class StringProblems {

    public static void main(String s[]){
        StringProblems stringProblems = new StringProblems();
        String string ="1123";
        int [] a = new int[string.length() +1];
       // int n =stringProblems.numberOfPossibleString(string, 0,a);
        String arr[] = new String[string.length()+2];
        int n2 = stringProblems.numberOfPossibleString2(string, 0,"",0,arr);
       // stringProblems.dialPadProblem("234");

//        for(int i =0; i < string.length();i++){
//            a[i] = 0;
//        }

//         3 1 2 3 1 3 4
//        12 3 1 3 4
        // 8 9 8 7 3 4 5 3 9
        // 1 2 3
        //  1  23
        // 2 3
        // 12 3
        //



        System.out.println(n2);

    }
    /*
    112156
    1 2 2 1 5 6
               6
             5 6
             15 6
             1 5 6
             2 15 6
             2 1 5 6
             21 5 6




     */

    public int numberOfPossibleString2(String s, int i, String s2, int k, String [] arr){
        System.out.println("recursion call count = "+ ++k);
        if(i >= s.length()){
            //System.out.println(s2);
            return 1;
        }
        if(i==s.length() -1){
//            if(arr[i]!=null){
//                System.out.println("...found..returning");
//               // System.out.println(arr[i]);
//                return 1;
//            }
            Character c = covertAsciitoChar((int)(s.charAt(i)+16));
            s2 = s2.concat(c.toString());
            System.out.println(s2);
            s2.replace(c.toString(),"");
            arr[i]=s2;
            return 1;
        }
        Character c = covertAsciitoChar((int)(s.charAt(i)+16));
        s2 = s2.concat(c.toString());
       int r1= numberOfPossibleString2(s,i+1,s2,k,arr);
       int r2=0;
        s2.replace(c.toString(),"");
        if(validChar(s.charAt(i),s.charAt(i +1))){
//            if(arr[i+2]!=null){
//                System.out.println("...found..returning");
//                System.out.println(arr[i+2]);
//                return 1;
//            }
            Integer c1 = (int)s.charAt(i);
            Integer c2 = (int)s.charAt(i +1);
            int c3 = ((c1-(int)'0')*10 + c2-(int)'0') + 'A' -1;
           // System.out.println(c3);
           // Character c4 =  Character.forDigit(c3 ,10);
            String c4 =  Character.toString((char)c3);
            Character c5= c4.charAt(0);
            //System.out.println(c4.charAt(0));

            //Character i3 = ((c1-'0')*10 + c2-'0');
            //Character c3 = (Character) i3 ;
            String s3=s2.substring(s2.length()-1);
            //s2=
            s2=s2.replace(s3,"");
            s2 = s2.concat(c5.toString());
            r2 = numberOfPossibleString2(s,i+2,s2,k,arr);
            s2.replace(c5.toString(),"");
            s2 = s2.concat(s3);
        }

        return r1 + r2;
    }
    public int numberOfPossibleString(String s, int i, int a[]){

        if(s == null || s.isEmpty()) return 0;

        if(i >=s.length()){
            a[i] = 0;
            return 0;
        }
        if(i == s.length() -1){
            a[i] = 1;
            return 1;
        }

        if(a[i] !=0) return a[i];

        int n1 = numberOfPossibleString(s,i+1, a);
        int n2 = numberOfPossibleString(s, i+2, a);
        int n =0;
        if(validChar(s.charAt(i), s.charAt(i+1))){
            if(n2 ==0) {
                a[i] = n1 + n2 + 1;
            }
            else {
                a[i] = n1 + n2;

            }
            //return a[i];
        }
        else{
            a[i] = n1;
        }
        return a[i];

    }

    private boolean validChar(Character c1 , Character c2){

        if(((c1-'0')*10 + c2-'0') <=26){
            return true;
        }
        return false;
    }

    private Character covertAsciitoChar(int code){

        String c4 =  Character.toString((char)code);
        return c4.charAt(0);

    }

    public void dialPadProblem(String number){
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");

        dialPadProblemUtil(number,0, map,"");



    }
    public void dialPadProblemUtil(String number, int i, Map<Character, String> map, String text){
        if(i>number.length() -1){
            System.out.println(text);
            return;

        }
        String s = map.get(number.charAt(i));
        for(int k =0;k< s.length() ;k++){
            Character c = s.charAt(k);
            text = text.concat(c.toString());
            dialPadProblemUtil(number, i+1, map,text);
            text = text.replace(c.toString(), "");

        }
    }


}
