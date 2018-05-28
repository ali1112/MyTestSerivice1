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
		System.out.print(graph.checkPathExist(0,5));

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

	public boolean checkPathExist(int a, int b){
		System.out.println("checkPathExist");
		List<Integer> list = new LinkedList<Integer>();
		list.add(a);
		boolean pathFound=false;
		boolean [] marked = new boolean[adj.size()];
		while(!list.isEmpty()){
			int node = list.remove(0);
			if(node == b){
				return true;
			}
			if(!marked[node]){
				marked[node] = true;
				System.out.println("Node= "+node);
			}
			List<Integer> adjNodes= adj.get(node);
			for(int i =0; i <adjNodes.size(); i++){
				if(!marked[adjNodes.get(i)]){
					list.add(adjNodes.get(i));
				}
			}
		}
		return false;
	}

}
