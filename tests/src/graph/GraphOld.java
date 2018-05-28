package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphOld {

	List<Node> nodes;
	Node root;

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> list) {
		this.nodes = list;
	}

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n8 = new Node(8);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n7 = new Node(7);

		GraphOld graph = new GraphOld();
		graph.setRoot(n1);

		Node[] children = { n1, n2, n4, n5, n7, n8 };
		graph.setNodes(Arrays.asList(children));

		Node[] nodeArray1 = { n2, n5 };
		Node[] nodeArray2 = { n8, n7 };
		Node[] nodeArray4 = { n5 };
		Node[] nodeArray5 = { n2, n4 };
		Node[] nodeArray7 = {};
		Node[] nodeArray8 = { n2, n5 };

		n1.setChildren(Arrays.asList(nodeArray1));
		n2.setChildren(Arrays.asList(nodeArray2));
		n4.setChildren(Arrays.asList(nodeArray4));
		n5.setChildren(Arrays.asList(nodeArray5));
		n7.setChildren(Arrays.asList(nodeArray7));
		n8.setChildren(Arrays.asList(nodeArray8));

		graph.traverseBfs();

	}

	public void traverseDfs() {

		dfs(root);

	}

	public void traverseBfs(){
		traverseBfs(root);
	}
	public void traverseBfs(Node node) {

		if (node == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();

		queue.add(node);

		while (!queue.isEmpty()) {

			Node n = queue.removeFirst();
			if (n.isVisited()) {
				continue;
			}

			List<Node> children = n.getChildren();
			visitNode(n);
			if (!children.isEmpty()) {

				for (Node child : children) {
					queue.add(child);

				}
			}
		}

	}

	public void dfs(Node node) {
		if (node == null) {
			return;
		}
		visitNode(node);

		List<Node> children = node.getChildren();

		for (Node child : children) {
			if (!child.isVisited()) {
				dfs(child);

			}
		}

	}

	public void visitNode(Node node) {
		node.setVisited(true);
		System.out.println("Node visisted : " + node.getData());
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	

}
