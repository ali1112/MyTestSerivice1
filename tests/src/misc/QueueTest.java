package misc;

import java.util.Scanner;

public class QueueTest {

	public static void main(String args[]){
		
		// Scanner scanner = new Scanner(System.in);
		 
		/* while(scanner.hasNext()){
			 String nextLine = scanner.nextLine();
			 System.out.println(nextLine); 
			 if(nextLine.equals("q")) break;

			 
		 }*/
		
		 QueueLinkedList<String> queue = new QueueLinkedList<String>();
		 
		 queue.enqueue("this");
		 queue.enqueue("is");
		 queue.enqueue("not");
		 queue.dequeue();
		 queue.enqueue("a");
		 queue.enqueue("game");
		 
		 while(!queue.isEmpty()){
			 System.out.println(queue.dequeue());
		 }

		 
		 
	}
	
	 
}
