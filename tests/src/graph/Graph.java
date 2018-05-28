package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	//ArrayList<ArrayList<Integer>> V;
	int v;
	private ArrayList<ArrayList<Integer>> adj;

	public Graph(int v){
		this.v= v;
		adj =  new ArrayList<ArrayList<Integer>>();
		for(int i =0 ; i <v;i++){
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public ArrayList<Integer> adj(int v){
		
		return adj.get(v);
		
	}
	
	public static void main(String arg[]){
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(2,3);
		graph.addEdge(2,4);
		graph.addEdge(1,3);
		graph.addEdge(0,3);
		graph.addEdge(3,4);
		graph.addEdge(0,2);
		graph.addEdge(4,5);
		
		graph.printEdges();
		
		DepthFirst df = new DepthFirst(graph, 0);
		//df.dfs(graph, 0);
		System.out.println("EdgeTo");
		df.printEdgeTo();
		
		System.out.println("TopologicalSort");
		df.topologicalSort(graph, graph.V());

	}
	

	
	public void addEdge(int v, int w){
		adj.get(v).add(w);
		//adj.get(w).add(v);
	}
	
	public void addDiGrapghEdge(int v, int w){
		adj.get(v).add(w);
	}
	
	
	public int V(){
		
		return v;
	}
	
	public void printEdges(){
		for(List<Integer> v:adj){
			for(Integer w:v){
				System.out.println(adj.indexOf(v)+"--"+w);
			}
		}
	}
	

}
