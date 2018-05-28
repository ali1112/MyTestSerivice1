package misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DP {

public void lps(){
		
		String s="banana";
		int a[][] = new int[6][6];
		int max = 1;
		for(int i =0;i<6;i++){
			a[i][i] = 1;
		}
		
		for(int i =1;i<6;i++){
			if(s.charAt(i-1) == s.charAt(i)){
				a[i][i] = 1;
				max= 2;
			}
		}
		
		for(int i = 2; i < 6 ; i++){
			int k =0;
			int j=i;
			int len = i-1;
			while(j<6){
				if(s.charAt(k) == s.charAt(j) && a[k+1][j-1] ==1){
					a[k][j] =1;
					len=i-1 + 2;
					if(len > max ) max = len;
				}
				j++;k++;
			}
		}
		
		for(int i =0 ; i < 6 ; i ++){
			System.out.println("");
			for(int j=0; j < 6; j++){
				System.out.print(a[i][j]+" ");

			}
		}
		
		System.out.println("max = "+max);
	}

	public static void main(String a[]){
		DP dp = new DP();
		//dp.editDistance();
		//System.out.println(dp.min(1, 8, 0));
		HashMap<Integer, Integer> map = new HashMap<>();
		//dp.coinChange(new Integer[]{1, 3, 2}, 5 , map);
		//dp.printMap(map);
		dp.coinChangeDp(new int[]{2, 3}, 7);
		
	}

	public void editDistance(){
	
		 char s11 [] ="abedg".toCharArray();
		 char [] s22= "abfhg".toCharArray();
		
		 int a[][] = new int[s22.length+1][s11.length+1];
		 
		 for(int i =0;i<a.length;i++){
			 a[i][0] =  i;

		 }
		 for(int i =0;i<a[0].length;i++){
			 a[0][i] =  i;

		 }
		 
		 for(int i = 1 ; i < a.length ; i ++){
			 for(int j = 1;j<a[0].length;j++){
				 if(s22[i-1] == s11[j-1]){
					 a[i][j] = a[i-1][j-1];
					 
				 }
				 else{
					 a[i][j] = min(a[i-1][j],a[i][j-1],a[i-1][j-1]) +1;
				 }
			 }
		 }
		 
		 printMatrix(a);
		
	}

	private int min(int a, int b , int c) {
		if(a > b){
			if(b > c){
				return c;
			}
			
			else if(c > a){
				return b;
			}
			
		}
		else if(c > a){
			return a;
		}

		return c;
		
	}
	
	public void printMatrix(int a[][]){
		for(int i =0 ; i < a.length ; i ++){
			System.out.println("");
			for(int j=0; j < a[0].length ; j++){
				System.out.print(a[i][j]+" ");

			}
		}
	}
	
	public int coinChange(Integer a[], int sum, HashMap<Integer, Integer> map){
		if(sum == 0) return 0;
		if(map.containsKey(sum)) return map.get(sum);
		int min = Integer.MAX_VALUE;
		for(int i =0; i < a.length; i++){
			int x = sum;
			x = sum - a[i];
			if(x < 0) continue;
			
			/*else if(x ==0){
				return 0;
			}*/
			
			
		   int count = coinChange(a, x, map);
		   if(count == -1) continue;
		   
		   if( count < min){
			   min = count;
		   }
		
			
		}
		   
		if(map.containsKey(sum)){
			if(map.get(sum) > min +1 ){
				map.put(sum, min+1);				
				}
		}
		else{
			map.put(sum, min+1);
		}
			
		return min + 1;
	}
	
	public void coinChangeDp(int []c, int sum){
		
		int a[] = new int[sum+1];
		int b[] = new int[sum+1];
		
		for(int i =0;i<=sum ; i++){
			a[i] = Integer.MAX_VALUE -10;
		}
		a[0] = 0;
		b[0] = 0;
		for(int i =0;i< c.length;i++){
			
			int coin = c[i];
			for(int j =1;j<=sum;j++){	
				if(coin > j) continue;
				int coinRequired = a[j - coin] +1;
				if(coinRequired < a[j]){
					a[j] = coinRequired;
					b[j] = coin;
				}
			}
		}
		
		printArray(a);
		System.out.println();
		printArray(b);
		System.out.println();

		
		int x = sum;

		for(int i = a[sum];i>0;i--){
			System.out.println(b[x]);
			x=x-b[x];

		}

	}
	public void printMap(Map map){
		Set keys = map.keySet();
		Iterator<Integer> itr = keys.iterator();
		
		while(itr.hasNext()){
			Integer key = itr.next();
			System.out.println("key = " +key+" value = "+map.get(key));
		}
	}
	
	public void printArray(int[] a){
		for(int i =0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	
}
