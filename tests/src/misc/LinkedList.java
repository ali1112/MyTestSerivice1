package misc;

import java.util.Iterator;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item> {

	Node <Item> first = null;
	
	public static void main(String [] args){
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(3);
		list.add(21);
		list.add(87);
		list.add(34);
		
		for(Integer integer:list){
			System.out.println(integer);
		}
		
		list.remove(21);
		
		for(Integer integer:list){
			System.out.println(integer);
		}
		
		list.reverse();
		System.out.println("Reverse");

		
		for(Integer integer:list){
			System.out.println(integer);
		} 
		if(list.isEmpty()){
			System.out.println("Empty");
		}
		
	}

	public void add(Item item) {

		Node<Item> node = new Node<Item>();
		node.item = item;

		if (isEmpty()) {
			first=node;
			return;
		}

		Node<Item> oldFirst = first;
		node.next = oldFirst;
		first = node;
		
	}
	
	public void reverse(){
		if(isEmpty()) return;
		
		Node<Item> current = first;
		
		Node<Item>  previous = null;
		
		while(current != null){
			
			Node<Item> next = current.next;
			current.next = previous;
			
			previous = current;
			current = next;
			
		}
		first = previous;
	}
	
	public Item remove(Item i){
		
		Node<Item> first = this.first;
		
		Node<Item>  ptr = first;

		while(first != null){
		
			if(first.item.compareTo(i) == 0){
				Item item = first.item;
				ptr.next = first.next;
				return item;
			}
			else{
				ptr = first;
				first = first.next;

			}
		}
		return null;
		
	}
	
	public Boolean isEmpty(){
		
		return first == null;
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{

		Node<Item> current = first;

		@Override
		public boolean hasNext() {
			
			return current != null;
		
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove(){

		}
		
	}

	
}
