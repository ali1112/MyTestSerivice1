package misc;

import java.util.Arrays;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class MergeSorting {

	public Integer[] mergeSort(Integer[] a1,Integer[] a2){
		
		int k = a1.length + a2.length ;//+ a3.length;
		Integer []a4 = new Integer[k];
		
		int l=0; int m=0; int n=0;
		for(int i = 0 ; i < k ; i++){
		
			if(a1[l]<a2[m]){
				
				a4[i] = a1[l++];
			}
			else{
				a4[i] = a2[m++];
			}
			
			if (m == a2.length || l==a1.length){
				
				while(l<a1.length){
					a4[++i] = a1[l++];
				}
				
				while(m<a2.length){
					a4[++i] = a2[m++];
				}
				break;
			}
			
			
			
			//k++;
		}
		
		return a4;
	}
	

	public void merge(int []a, int l, int m , int n){
		//System.out.println("l "+l+" m="+m+"n="+n);
		int k = m;
		while(l<n){
			if(a[l]>a[n]){
				//System.out.println("comparing "+a[l] +" and "+a[n]);
				swap(a,l,n);;
				n--;
			}
			else l++;
		}
		/*while(l <=n){
			if(a[l]>a[k]){
				swap(a,l,k);
			}
			l++;
		}*/
		
	}
	public void swap(int a[], int m , int n){
		int temp = a[m];
		a[m] = a[n];
		a[n]=temp;
	}
/*	6 , 2, 3 , 1 ,5
	6 2 3     5 1
	
	6 2   3    1  5
	
	1 2   3     6  5
	
	 2, 3	6	 , 1 ,5                          ,11,18,13		,12,15
													  11,18  13
	
	6 2 	3															12, 15
	
	6 2  
	2  6   3        1   5												12      15
	
	2 3 6           1   5
	
	1 2 3 4 5 6                                    11 18   13
												11    18		13
												11 13 18              12		15
												
												
	2 3 6 1 5\
	1 3 6  2 5
	1 2 3    6 5
	
	*/
	
	public void mergeSort(int[] a, int m , int n){
		System.out.println("m= "+m+"n= "+n+" k = "+(m +n)/2);

		if(m==n || n<m) {
			return;
		}
		
		int k = (m +n)/2;
		
		mergeSort(a,m,k);
		mergeSort(a,k+1,n);
		merge(a,m,k,n);
		
	}
	
	/*0 9
	04 59
	02 34
	01 22      33 44
	
	57 89
	56 77
	55 66   77 */

	public Integer[] mergeSort(int n){
		
		Integer[][] a = new Integer[][]{
			  {2 , 5, 8 ,9 },
			  { 1, 3, 6,  7, 10 },
			  { 4, 5 , 9 ,10 , 11, 15 },
			  { 2, 5, 8, 11, 12 },
			  { 5, 8 , 9 , 12 ,11 }
			};
		
		if(a == null ){
			return null;
		}
		
		if(a.length < 2){
			return a[0];
		}
		
		int col = a[0].length;
		int row = a.length;
		
		Integer result [] = new Integer[row*col];
		int i =0, j=0;
		
		while(i< row-1){
			/*Integer b[] = a[i];
			Integer c[] = a[i+1];
			Integer d[] = mergeSort(b, c);
			
			int k=0;
			
			while(k<d.length){
				result[j++] = d[k++];
			}
			
			i = i+2;*/
			int r1=0 ; int r2=1;
			int r3 =1 ; int r4=2;
			Integer[] b = getArray1Elements(a, r1, r2);
			Integer[] c = getArray1Elements(a, r3, r4);
			Integer d[] = mergeSort(b, c);
			
		}
		
		if(i==row-1){
			result = mergeSort(Arrays.copyOfRange(result, 0,j), a[i]);
			
		}
		
		return result;
		
	}
	
	private Integer[] getArray1Elements(Integer[][] a, int rowStart, int rowEnd){
		
		
		int col = a[0].length;
		int row = a.length;
		
		Integer[] resultArray = new Integer[col*(rowEnd - rowStart + 1)];
		int k = 0;
		
		while(rowStart <= rowEnd){
			
			copyArray(resultArray,k,a[rowStart++]);
		}
		return resultArray;
	}
	
	private void copyArray(Integer [] dest, int destStart, Integer []src){
		int l = src.length;
		int j =0;
		while(j<l){
			dest[destStart++]= src[j++];
		}
	}
	
	
	/*
	 * 2 , 5, 8 ,9
	 * 1, 3, 6,  7
	 * 4, 5 , 9 ,10
	 * 4, 9 , 19 ,20
	 * 0, 5, 8 , 9
	 * 
	 */
	

}
 