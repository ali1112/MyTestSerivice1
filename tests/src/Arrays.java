import java.util.HashMap;
import java.util.Map;

/**
 * Created by msharafat on 4/2/17.
 */
public class Arrays {


    public static void main(String [] args){

        Arrays arr = new Arrays();
        int a[] = {2,3,5,5,5,12,14,17,17};
        //System.out.print("valueFound = "+arr.findFrequencyOFANumber(a, 14) );
        int b[] = {2,3,5,7,8};
       // arr.findSumTriplet(b);

        Double x = Math.sqrt(45);
        System.out.println(x.intValue());

        System.out.println((char) 97);
        String s="";
        Character c= 'a';
        s= s + c;
        System.out.println(s);


    }


    public  void findSumTriplet(int a[]){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i =0 ; i< a.length; i++){

            int k = a[i];
            for(int j =0 ; j < a.length; j ++){
                if( i != j){
                    if(map.containsKey(k - a[j])){
                        System.out.println("triplet found: "+k+" "+(k-a[j])+" "+a[j]);
                    }
                    else{
                        map.put(a[j],a[j]);
                    }
                }
            }
            map.clear();
        }
    }
    public int findFrequencyOFANumber(int a[], int key){

        int beg = 0;
        int end = a.length-1;
        int mid = (beg + end)/2;
        int valueFound = -1;

        while(beg < end){

            //if(a[mid] == key) valueFound = mid;
            mid = (beg + end)/2;

            if(a[mid] < key){
                beg= mid+1;


            }

            else if(a[mid] >= key){
                end= mid-1;

                if (a[mid] == key){
                    valueFound = mid;
                }

            }


        }

        return  valueFound;
    }
}
