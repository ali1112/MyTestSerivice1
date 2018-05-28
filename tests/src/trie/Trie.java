package trie;

public class Trie{
	
	private Node root;


	private class Node {

		Node[] nodes;
		Object value;
	}

	public void insert(String s, Object value){
		
		if(s == null) return;
		
		if(root == null){
			root = new Node();
		}
		Node n = root;
		for(int i =0 ;i<s.length();i++){
			if(n.nodes == null){
				n.nodes = new Node[255];
			}
			Node node = n.nodes[s.charAt(i)];
			if(node == null){
				node = new Node();
				n.nodes[s.charAt(i)] = node;
			}
			n = node;
		}
		n.value = value;
	}
	
	public static void main(String []s){
		Trie t= new Trie();
		t.root = t.new Node();
		//t.printNodeElements(t.root);
		t.insert("sharafat", 8);
		t.insert("shar", 4);
		t.insert("shap", 5);
		t.printTrie(t.root);
		System.out.println("..........");
		
		System.out.println("Searching");

		System.out.println(t.search("sharafat"));
		
	}
	private void printNodeElements(Node node){
		for(int i = 0 ;i<255;i++){
			System.out.print(node.nodes[i]+"  ");
		}
	}
	
	private void hasChildren(Node node){
		
	}
	
	public int search(String s){
		
		Node n = root;
		for(int i =0 ;i < s.length(); i++){
			
			if(n == null ) return -1;
			Node[] nodes = n.nodes;
			if(nodes == null || nodes[i] != null) return -1;
			
			n = nodes[s.charAt(i)];
		
		}
		if(n!= null && n.value != null) return (int)n.value;
		
		return -1;
		
	}
	public void printTrie(Node node){
		if(node.nodes == null ) return;
		System.out.println();
		Node [] nodes= node.nodes;
		boolean hasChildren = false;
		for(int i =0;i<255;i++){
			if(nodes[i] !=null){
				hasChildren= true;
				//Character c = new Character(i.byteValue());
				System.out.print((char)i+" ");
				if(nodes[i].value != null){
					System.out.print("value = "+(Integer)nodes[i].value);
					//continue;
				}
				printTrie(nodes[i]);
			}
			
		}
		if(hasChildren){
			//System.out.println();
		}
	}
	
	private void getAllSuffix(String s){
		
	}
}




