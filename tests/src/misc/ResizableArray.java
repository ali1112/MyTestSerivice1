package misc;

public class ResizableArray {

	int size = 1;
	int n=0;
	Integer[] a = new Integer[1];
	
	public void add(Integer value){
		if(n>=size/2){
			System.out.println("Resizing array");
			System.out.println("n = "+n);
			System.out.println("size = "+size);

			
			size=2*size;
			a = copy(a, new Integer[size]);
		}
		a[n++] = value;
	}
	
	public void remove(int value){
		for(int i =0; i < n -1 ; i ++){
			if( a[i] == value){
				while(i+1 < n){
					a[i]=a[i+1];
					i++;
				}
				n--;
				break;
			}
		}
		
		if(n <= a.length/4 ){
			size=size/2;
			a= copy(a, new Integer[size]);
			
		}
	}
	
	private Integer[] copy(Integer src[], Integer dest[]){	
		for(int i =0; i<n;i++){
			//System.out.println("Coping ");
			dest[i] =src[i];
			//i++;
		}
		return dest;
		
	}
	
	public void print(){
		for(int i =0;i<n;i++){
			System.out.println(a[i]);
		}
	}
	
}
