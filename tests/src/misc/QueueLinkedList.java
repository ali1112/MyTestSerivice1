package misc;

public class QueueLinkedList<Item> {

	Node <Item> first = null;
	Node <Item> last = null;

	public void enqueue(Item item) {

		Node<Item> node = new Node<Item>();
		node.item = item;

		if (isEmpty()) {
			first=node;
			last = node;
			return;
		}

		Node<Item> oldLast = last;

		oldLast.next = node;
		last = node;
	}
	
	public Item dequeue(){
		
		Item item = null;
		
		if(!isEmpty()){
			
			item = first.item;
			first = first.next;
			if(first==null) last=first;
			
		}
		return item;
	}
	
	public Boolean isEmpty(){
		return first == null &&  last == null;
		
	}

	private class Node<Item> {
		Item item;
		Node<Item> next;
	}
}
