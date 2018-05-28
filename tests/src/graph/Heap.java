package graph;

public class Heap<Key extends Comparable<Key>> {

	Integer N=-1;
	Key[] keys;
	
	public Heap(Key[] keys) {
		super();
		this.keys = keys;
		N=keys.length-1 ;
	}
	
	/*public Heap(int capacity) {
		
	}*/
	
	public void buildHeap(){
		int k = 0;
		while(k <=N){
			heapifyUp(k++);
		}
		
	}
	public void insert(Key key){
		if(keys == null){
			//keys = new Key[10];
			keys[1] = key; return;
		}
		keys[++N] = key;
		//int k = N;
		//while(k>=N/2){
		heapifyUp(N);
		//}
	}
	
	public static void main(String a[]){
		Integer [] ar= {0,2,4,1,5,17,12,10,8,15};
		String [] ar2={"sdfsdf","sdasd","edfr","rftg","ewsqa","fdcv"};

		Heap<Integer> heap = new Heap<>(ar);
		Heap<String> heap2 = new Heap<>(ar2);

		/*heap.insert(4);
		heap.insert(3);
		heap.insert(6);
		heap.insert(2);
		heap.insert(13);
		heap.insert(1);*/
		heap2.buildHeap();
		heap2.printHeap();
		heap2.deleteMax();
		System.out.println("---------------");
		heap2.printHeap();
		//heap.insert(21);
		//System.out.println("---------------");
		//heap.printHeap();
	}
	
	public void printHeap(){
		int k =0;
		while(k <=N){
			System.out.println("index = "+k+"value = "+keys[k++]);
		}
	}
	
	public void deleteMax(){
		swap(0,N);
		N--;
		heapifyDown(0);
	}
	private void heapifyUp(int k){
		//int k =N;
		while(k>0 && less((k-1)/2, k)){	
				swap(k,(k-1)/2);
				k=(k-1)/2;
		}
	}
	
	private void heapifyDown(int k){
		
		while(k<=(N-1)/2){
			int j =2*k+1;
			if(j+1 <=N-1){
				if(less(j,j+1))j++;
			}
			if(less(k,j)){
				swap(k,j);
			}
			k=j;
			
		}

	}
	
	private boolean less(int i, int j){
		//if(i > N || j >N) return false;
		if(keys[i].compareTo(keys[j]) < 0) return true;
		return false;
	}
	private void swap(int i , int j){
		Key temp = keys[i];
		keys[i] =keys[j];
		keys[j] = temp;
	}
}
