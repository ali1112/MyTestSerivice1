package graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	Integer data;
	List<Node> children;
	boolean visited = false;
	
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public Node(Integer data, ArrayList<Node> children) {
		super();
		this.data = data;
		this.children = children;
	}
	
	public Node(Integer data) {
		super();
		this.data = data;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
	
}
