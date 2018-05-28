package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {

	public static void printMap(Map map){
		Set keys = map.keySet();
		Iterator<Integer> itr = keys.iterator();
		
		while(itr.hasNext()){
			Integer key = itr.next();
			System.out.println("key = " +key+" value = "+map.get(key));
		}
	}
	
	public static void printArray(int[] a){
		for(int i =0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String []s){
		 int []a =new int[]{4,2,6,5,4,3}; 

		Arrays.sort(a);
		Utils u= new Utils();
		ArrayList<Integer> a1= new ArrayList<Integer>();
		u.test(a1);
		
	}

	public void test(List list){
		
	}
}
