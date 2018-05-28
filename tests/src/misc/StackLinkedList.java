package misc;

public class StackLinkedList<Item> {

	private Node<Item> first;

	public void push(Item item) {

		Node<Item> node = new Node<Item>();
		node.item = item;

		if (isEmpty()) {
			first = node;
			return;
		}

		Node<Item> oldFirst = first;

		node.next = oldFirst;
		first = node;

	}
	
	public Item pop(){
		Item item = null;
		
		if(!isEmpty()){
			item = first.item;
			first = first.next;
			
		}
		return item;
	}
	
	public Boolean isEmpty(){
		return first == null;
		
	}

	private class Node<Item> {
		Item item;
		Node<Item> next;
	}
}
