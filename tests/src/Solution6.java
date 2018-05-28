import java.util.HashMap;
import java.util.Map;
import java.util.*;


/**
 * Created by msharafat on 3/31/18.
 */
public class Solution6 {


    public static void main(String arg[]){
        Solution6 s= new Solution6();

       // s.letterCombinations("2");
        s.matrixCombinaiton(0,0,4, new ArrayList<String>());
    }

    public String[] letterCombinations(String A) {
        Map<Integer, Character[]> map = new HashMap<>();
        map.put(1, new Character[]{'1'});
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});
        map.put(0, new Character[]{'0'});
        List<String> list = new ArrayList<String>();
        // recurse2(map,list,A, new MyInt(0), "");
        list = generateStrings(map, A,new MyInt(A.length() -1));
        printList(list);

        //String s2[]= (String[])list.toArray();
        return convertToString(list,new String[list.size()], 0);
        // return new String[1];
    }
    public String[] convertToString(List<String> list, String[] a, int k){
        for(String s:list){
            a[k++]=s;
        }
        return a;
    }

    public void printList(List<String> list){
        for(String s:list){
            System.out.println(s);
        }
    }

    public List<String> generateStrings(Map<Integer, Character[]> map, String A, MyInt myInt){
        if(myInt.getValue() < 0){
            String s = "";
            List<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }


        Integer num=A.charAt(myInt.getValue()) -'0';
        Character charArray[] = map.get(num);
        List<String> list2 = generateStrings(map,A,new MyInt(myInt.getValue() - 1));
        List<String> list3 = new ArrayList<>();


        for(int k=0;k<charArray.length;k++){
            int size = list2.size();
            for(int l=0;l<size;l++){
                String s2 = list2.get(l);
                //list2.remove(l);
                s2=s2.concat(charArray[k].toString());
                list3.add(s2);
                s2=s2.replace(charArray[k].toString(),"");

            }
            //MyInt myInt1 = new MyInt(myInt.getValue());
        }
        return  list3;
    }


    public class MyInt {
        Integer value;

        public MyInt(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public MyInt increment(){
            value++;
            return this;
        }
    }

    public void matrixCombinaiton(int m, int n, int k, List<String> list ){

        if(n >=k || m>=k){
            System.out.println();
            return;
        }

        while(m++<k){
                recrseMatrixCombinaiton(m,n,k,list,"");
               // System.out.print(" "+m+", "+n+"  ");

            //n--;

            //n++;
        }
    }

    public void recrseMatrixCombinaiton(int m, int n, int k, List<String> list, String s){
        if(n >=k || m>=k){
            list.add(s);
            System.out.println(s);
            return;
        }
        while(n++<k && m<=k){
           // System.out.print(" "+m+", "+n+"  ");
            s=s.concat(String.valueOf(m+","+n+" "));
            //System.out.print(m+" ");
            recrseMatrixCombinaiton(m,n,k, list,s);
            s.replace(String.valueOf(m+","+n+" "),"");

            m++;
        }
    }
}
