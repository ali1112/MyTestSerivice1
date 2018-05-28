import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner in = new Scanner(System.in);
        String keywrodsString = in.nextLine();
        String keywords[] = keywrodsString.split(" ");
        Set<String> keywordsSet = new HashSet<String >();
        for(int i =0;i<keywords.length; i++){
            keywordsSet.add(keywords[i]);
        }

        int reviews = Integer.parseInt(in.nextLine());
        Map<Integer,Integer> reviewMap = new TreeMap<Integer, Integer>();

        for(int i = 0;i < reviews;i++){
            int hotelId = Integer.parseInt(in.nextLine());
            String review = in.nextLine();
            review= review.replaceAll(",","");
            review= review.replaceAll("\\.","");


            int keywordCount=0;
            String tokens[] = review.split(" ");
            for(int j =0;j<tokens.length;j++){
                if(keywordsSet.contains(tokens[j])){
                    keywordCount++;
                }
            }
            if(reviewMap.containsKey(hotelId)){

                reviewMap.put(hotelId,reviewMap.get(hotelId) + keywordCount);

            }
            else{
                reviewMap.put(hotelId,keywordCount);
            }


        }
        List keys = new ArrayList(reviewMap.keySet());
        Collections.sort(keys);

        for(int i =keys.size() -1;i>=0;i--){
            System.out.print(keys.get(i)+" ");
        }
    }



}