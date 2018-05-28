
import model.MyInt;

import java.util.*;
import java.util.Arrays;

public class Solution5 {

    public static void main(String arg[]){
        Solution5 s= new Solution5();
        int a2[]= new int[] {80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90 };
        int[] a = new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
        //LinkedList<Integer> list = new LinkedList<Integer>(new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 });
        // int s2=  s.kthsmallest(new ArrayList<Integer>(Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65)), 4);
        // System.out.println(s2);
        //s.numRange(a2,99, 269);

        //int d = s.braces("((a+b))");
        s.letterCombinations("10");
    }

    public int braces(String A) {

        MyInt myInt = new MyInt(0);
        return recursion(A,myInt);

    }

    public int recursion(String s,MyInt i){
        int br=0;
        int op=0;
        while(i.getValue()<s.length()){

            char c = s.charAt(i.getValue());
            if(c==')'){
                if(op ==0){
                    return br +1;
                }
                else{
                    return br;
                }
            }
            if(c == '+'||c == '-'||c == '*'||c == '/'){
                op++;
            }
            if(c=='('){
                br = recursion(s, i.increment());
                char c2= s.charAt(i.getValue());
//                while(c2 != ')'){
//                    i.increment();
//                    c2= s.charAt(i.getValue());
//                }
//                i.increment();
            }
            i.increment();;

        }
        return br;
    }

    public int kthsmallest(final List<Integer> A, int B) {


        LinkedList<Integer> list = new LinkedList<Integer>();
        Boolean flag = false;
        for(Integer element:A){
            //           System.out.println("element  "+element);

            if(list.isEmpty()){

                list.add(element);
                continue;
            }
            int i =0;
            while(i< B&&i<list.size()&&list.get(i)<element){
                i++;
            }
            list.add(i,element);

            // for( i=0;i< B&&i<list.size(); i++){
            //       //System.out.println("i "+i);

            //     if(list.get(i)>element){
            //       flag=true;
            //       //System.out.println("i "+i);
            //       //System.out.println("list i "+list.get(i));

            //       //System.out.println("element  "+element);

            //         break;
            //     }
            // }
            // if(flag){
            //     list.add(list.size(),list.get(i));

            // }
            // list.add(i, element);

            // flag=false;
        }
        // print(list);
        return list.get(B-1);
    }

    public void print(List<Integer> l){
        for(Integer i:l){
            System.out.println(i);
        }
    }

    public int numRange(int[] A, int B, int C) {
        int i=0,i2=1,n=0;
        int sum=A[0];
        int newSum=0;
        while(i<A.length){

            if(sum < B){
                if(i2 < A.length){
                    sum = sum + A[i2++];
                }
                else{
                    i++;
                }
            }
            else if(sum > C){
                i++;
                i2=i;
                sum=0;
            }
            else if(sum >=B && sum <=C){
                n++;
                System.out.print("sum= "+sum+" -> ");
                printArray(A, i, i2-1);
                System.out.println();
                if(i2 < A.length){

                    sum = sum + A[i2++];
                }
                else{
                    i++;
                    i2=i;
                    sum=0;
                }
            }
        }
        System.out.print(n);
        return n;
    }
    public void printArray(int arr[] ,int a, int b){

        while(a <=b){
            System.out.print(arr[a++]+" ");
        }
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
    public void recurse2(Map<Integer, Character[]> map, List<String> list, String A, MyInt myInt, String s){
        if(myInt.getValue() >= A.length()){
            return;
        }

        if (s.length() >=A.length()){

           list.add(s);
           // s= "";
           return;
        }
        Integer num=A.charAt(myInt.getValue()) -'0';
        Character charArray[] = map.get(num);
        for(int k=0;k<charArray.length;k++){
            s=s.concat(charArray[k].toString());
            //MyInt myInt1 = new MyInt(myInt.getValue());
            recurse2(map,list, A,myInt.increment(),s);
            s=s.replace(charArray[k].toString(),"");
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


}
