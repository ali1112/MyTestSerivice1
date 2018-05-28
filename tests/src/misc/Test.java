package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Test {
	
	static Set<String>   subStringList ;

	public static void main (String[] args) throws Exception
	{
		
		
		//getSubsStrings(subStringList, "abcd");
		
		//for(String str:subStringList){
	//		System.out.println(str);
		//}

		Test t = new Test();
		//t.test1();
	//	t.getAllSubSequences(new ArrayList<>(), "abcd");
		 String str1= "abcdef";
		 String str2="ghijkl";
		 //t.findLcs(str1, str2);
		 
		 int[] a1= new int[]{6 , 2, 3 , 1 ,5,11,18,13,12,15};
		 
		 Integer[] a2= new Integer[]{4 , 7, 8 , 11 };
		 
		 Integer[] a3= new Integer[]{5 , 6, 9 , 11 };

		 MergeSorting m = new MergeSorting();
		// Integer a[] = m.mergeSort(a1, a2, a3);
		// Integer a[] = m.mergeSort(4);
		 
		/* for(int i =0 ;i< a.length;i++){
			 System.out.println(a[i]);
		 }*/
		// m.permutations("abc", "",0,0);
		 
		//m.mergeSort(a1, 0, a1.length-1);;
		
		/*for(int i =0 ;i< a1.length;i++){
			 System.out.println(a1[i]);
		 }*/
		 t.lps();
	}
	
	public void test1(){
		Set<String>   subStringList=new HashSet<String>();
		
		//getSubsStrings(subStringList, "abcd");
		
		List<String> list = getSubstring("abc");
		
		for(String str:list){
			System.out.println(str);
		}
			
	}
	
	public List<String> getSubstring(String str){
		List<String> list=new ArrayList<>();
		list.add(str);

		for(int i=0;i<str.length() ; i++){
			for(int j=i+1;j<str.length();j++){
				String str1 = str.substring(i,j);
				String str2= str.substring(j, str.length());
				list.add(str1);
				list.add(str2);
			}
		}
		return list;
	}
	public  void getSubsStrings(Set<String> subsStringList, String str){
		
		if(subsStringList == null){
			subsStringList = new HashSet<String>();
			
		}
		if(str.length() == 0){
			return ;
		}
		
		if(str.length() == 1){
			subsStringList.add(str);
			System.out.println("Substring Added : "+str); 

			return;
		}
		
		subsStringList.add(str);
		System.out.println("Substring Added : "+str); 

		
		String str1 = str.substring(0,1);
		
		//subsStringList.add(str1);
		//System.out.println("Substring Added : "+str1); 
		String str2 = str.substring(1,str.length());
		subsStringList.add(str2);

		//System.out.println("Substring Added : "+str2); 
		String str3 = str.substring(str.length() -1, str.length());
		
		//subsStringList.add(str3);
		//System.out.println("Substring Added : "+str3); 

		String str4 = str.substring(0, str.length() - 1);
		subsStringList.add(str4);
		//System.out.println("Substring Added : "+str4); 

		getSubsStrings(subsStringList, str1 );
		
		getSubsStrings(subsStringList, str2 );

		
		getSubsStrings(subsStringList, str3 );

		getSubsStrings(subsStringList, str4 );

		
	
	}
	
	public void getAllSubSequences(List<String> list, String str){
		
		if(str == null || str.length() == 0){
			return;
		}
		
		
		for(int i =0 ; i <str.length() ; i++){
			getSubsquence(list, str.substring(i,i+1), str.substring(i+1,str.length()) );

		}
		
		for(String st1r:list){
				System.out.println(st1r);
		}
		
	}
	
	public void getSubsquence(List<String> list, String prefix, String suffix){
		if(suffix == null || prefix == null){
			return;
		}
		//System.out.println(prefix+" , "+suffix);

		if(prefix.length() == 0){
			
		}
		if(suffix.length() == 0){
			//list.add(prefix);
			return ;
		}
		
		//list.add(prefix);
		for(int i =0 ; i <suffix.length();i++){
			String s = prefix + suffix.charAt(i);
			list.add(s);
		}
		getSubsquence(list, prefix+suffix.substring(0,1), suffix.substring(1,suffix.length()) );

	}
	 /*
	  *  str1= "abcdef"
	  *  str2="klmn"
	  */
	public void findLcs(String str1, String str2){
		
		int lcsl=0;
		String lcs="";
		int count=0;
		for(int i = 0 ; i < str1.length() ; i ++){
			System.out.println("count = "+ ++count);

			for(int j=i; j < str1.length(); j ++){
				System.out.println("count = "+ ++count);

				String subStr1=str1.substring(i, j+1);
				System.out.println("SubsString = "+subStr1);

				int l=0,k=0;
				while(l<subStr1.length() && k<str2.length()){
					System.out.println("count = "+ ++count);

					System.out.println("Comparing = "+subStr1.charAt(l) +" and "+str2.charAt(k));

					if(subStr1.charAt(l)== str2.charAt(k)){
						
						l++;k++;
					}
					else{
						l=0;
						k++;
					}
					
					if(l==subStr1.length()){
						System.out.println("SubsString found = "+subStr1);
						if(subStr1.length() > lcsl){
							lcs=subStr1;
						}
					}
				}
				
			}
		}
	}
	
	 public void reduceString(String str){
	        Stack<Character> stack = new Stack<Character>();
	        for(int i =0; i < str.length(); i++){
	            if(stack.isEmpty()){
	                stack.push(str.charAt(i));
	            }
	            
	            Character char1 = stack.pop();
	            if(!(char1 == str.charAt(i))){
	                stack.push(str.charAt(i));
	                str=str.substring(i, str.length());
	            }
	            
	        }
	        
	        if(stack.isEmpty()){
	            System.out.println("Empty String");
	        }
	        
	        
	        else{
	            String returnString="";

	        	while(stack.isEmpty()){
	                returnString = returnString + stack.pop();
	            }
	            
	            //System.out.println(returnString);
	        }

	 }
	 
		public void permutations(String str, String pefix,int count, int forLoop){
			System.out.println(count++);
			
			if(str == null) return;
			System.out.println("str : "+str +" prefix = "+pefix);

			if(str.length() == 0){
				System.out.println("permution : "+pefix);
			}
			else{
				for(int i = 0;i<str.length();i++){
					System.out.println("forloop "+ forLoop++);
					String rem = str.substring(0,i) + str.substring(i+1);
					System.out.println("rem = "+rem);
					permutations(rem, pefix + str.charAt(i), count, forLoop);
			}
			
				
			}
			
		}
		
		
	public char[] comporessString(){
		String str="aaabbcddee";
		char [] a = str.toCharArray();
		
		int i =0 , j= a.length-1;
		int k=j;
		while(a[k] == ' '){
			k--;

		}
		k--;
		while(k>=0){

			int count  = 1;
			while(k>=0 && a[k] ==a[k+1]){
				
				count++;
				a[k+1] = ' ' ;
				k--;

			}

			a[j--] = (char) ('0' + count);
			a[j--] = a[k+1];
		}
		return a;
		
		/*for(int i =1; i <charArray.length;i++){
			int count = 1; 
			int j = i;
			while((charArray[i] == charArray[i-1]) && i<charArray.length){ // i=1
				count++;
				charArray[i] = ' ';
				
			}
			
			if(charArray[j] == ' '){
				charArray[j] = (char) (count + '0');
			}
			
			count = 1;
			
		}
		
		int j =1;
		for(int i =1; i <charArray.length;i++){
			while((charArray[i] == ' ') && i<charArray.length){
				charArray[j] = charArray[i];
				charArray[i] = ' ';
				i++;
				j++;
				
			}
		
			
		}
		
		return String.valueOf(charArray);*/
	
	}
	
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
}

