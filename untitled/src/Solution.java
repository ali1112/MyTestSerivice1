import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /*
    * Complete the function below.
    */
    static int programmerStrings(String s) {

        if( s == null ||  s.isEmpty() || s.length() < "programmer".length()){
            return 0;
        }
        int totalProgString = 0;
        for(int i = 10; i < s.length()-9; i++){
            String subStr1 = s.substring(0,i);
            String subStr2 = s.substring(i+1,s.length());

            if(containsProgrammerString(subStr1, subStr2)){
                totalProgString++;
            }
        }
        return  totalProgString;
    }


    private static boolean containsProgrammerString(String s1, String s2) {
        if(s1 == null | s2 == null || s1.length() < 10 || s2.length() < 10)
            return false;

        Map<Character, Integer> progreamerStringMap = new HashMap<Character, Integer>();

        Map<Character, Integer> passedStringMap1 = new HashMap<Character, Integer>();
        Map<Character, Integer> passedStringMap2 = new HashMap<Character, Integer>();


        progreamerStringMap.put('p', 1); // programmer
        progreamerStringMap.put('r', 3);
        progreamerStringMap.put('o', 1);
        progreamerStringMap.put('g', 1);
        progreamerStringMap.put('a', 1);
        progreamerStringMap.put('m', 2);
        progreamerStringMap.put('e', 1);

        for (int i = 0; i < s1.length(); i++) {
            if (!passedStringMap1.containsKey(s1.charAt(i))) {
                passedStringMap1.put(s1.charAt(i), 1);
            } else {
                int k = passedStringMap1.get(s1.charAt(i));
                passedStringMap1.put(s1.charAt(i), k+ 1);
            }

        }

        for (int i = 0; i < s2.length(); i++) {
            if (!passedStringMap2.containsKey(s2.charAt(i))) {
                passedStringMap2.put(s2.charAt(i), 1);
            } else {
                int k = passedStringMap2.get(s2.charAt(i));
                passedStringMap2.put(s2.charAt(i), k+ 1);
            }

        }

       return checkProgString(progreamerStringMap, passedStringMap1) && checkProgString(progreamerStringMap, passedStringMap2);


    }

    private static boolean checkProgString(Map<Character, Integer> map1, Map<Character, Integer> map2) {

        Iterator itr = map1.keySet().iterator();

        while (itr.hasNext()) {
            Character c = (char) itr.next();
            if(map1.get(c) !=null){
                if(map2.get(c) == null){
                    return false;
                }
                if (map2.get(c) < map1.get(c)) {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) throws IOException {
       int k = programmerStrings("xprogxrmaxemrppprmmograeiruu");
       System.out.print(k);}
}
