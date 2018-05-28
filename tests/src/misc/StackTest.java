package misc;

import java.util.Scanner;

public class StackTest {

	public static void main(String args[]){
		
		/* Scanner scanner = new Scanner(System.in);
		 scanner.delimiter();
		 while(scanner.hasNext()){
			 String next = scanner.next();
			 System.out.println(next);
			 
			 if(next.equals("q")) break;

			 
		 }
		
		StackLinkedList<String> stack = new StackLinkedList<String>();
		stack.push("this");
		stack.push("is");
		stack.pop();
		stack.push("a");
		stack.push("game");
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
*/
		
		ResizableArray a = new ResizableArray();
		a.add(1);
		a.add(3);
		System.out.println("size= "+a.size);
		a.add(5);
		a.add(6);
		System.out.println("size= "+a.size);

		a.add(2);
		a.add(12);
		System.out.println("size= "+a.size);

		a.add(10);
		System.out.println("n= "+a.n);

		System.out.println("size= "+a.size);

		a.print();
		
		System.out.println("-----------------------------");
		a.remove(6);
		System.out.println("n= "+a.n);

		a.print();
		a.remove(2);
		System.out.println("size= "+a.size);
		a.remove(1);
		a.remove(12);
		a.print();

		System.out.println("size= "+a.size);
		System.out.println("n= "+a.n);


		
		
		
	}
}
