package misc;

public class Node<Item extends Comparable<Item>> implements Comparable<Node<Item>> {
	Item item;
	Node<Item> next;

	@Override
	public int compareTo(Node<Item> o) {
		if (o == null)
			return -1;
		if (item == null) {
			if (o.item != null) {
				return -1;
			}
		}

		return item.compareTo(o.item);

	}

}
