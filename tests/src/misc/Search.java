package misc;

public class Search {

	public static void main(String a[]){
		Search s  = new Search();
		int k =s.binarySearch(new int[]{2, 4, 6, 7,9,10}, 0,5, 15);
		System.out.println(k);
	}
	public int binarySearch(int a[], int beg, int end, int k){
		
		if(end <= beg ) return -1;
		int mid = (beg+ end)/2;
		
		if(a[mid] == k) return mid;
		else if(k > a[mid]){
			return binarySearch(a, mid+1, end, k);
		}
		if(k<= a[mid]){
			return binarySearch(a, beg , mid-1,k);
		}
		return mid;
	}
	
	/*public int binarySearch2(int a[], int beg, int end, int k){
		
		//if(end <= beg ) return -1;
		
		while(beg < end){
			int mid = (beg+ end)/2;
			if(a[mid] > k){
				beg = mid+1;
			
			}
			else{
				end = mid-1;
			}
		}
		
		
		/*if(a[mid] == k) return mid;
		else if(k > a[mid]){
			return binarySearch(a, mid+1, end, k);
		}
		if(k< a[mid]){
			return binarySearch(a, beg , mid-1,k);
		}
		return mid;*/
	//}
	
	public int floor(int a[], int beg, int end, int k){
		
		if(end <= beg ) return -1;
		int mid = (beg+ end)/2;
		
		if(a[mid] == k) return mid;
		else if(k > a[mid]){
			return binarySearch(a, mid+1, end, k);
		}
		if(k< a[mid]){
			return binarySearch(a, beg , mid-1,k);
		}
		return mid;
	}
}
