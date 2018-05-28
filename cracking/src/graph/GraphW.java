package graph;

import java.util.*;

public class GraphW {

	//ArrayList<ArrayList<Integer>> V;
	int v;
	private ArrayList<Map<Integer, Integer>> adj;

	public GraphW(int v){
		this.v= v;
		adj =  new ArrayList<Map<Integer, Integer>>();
		for(int i =0 ; i <v;i++){
			adj.add(new HashMap<Integer, Integer>());
		}
	}
	
	public Map<Integer, Integer> adj(int v){
		
		return adj.get(v);
		
	}
	
	public static void main(String arg[]){
		GraphW graph = new GraphW(6);
		graph.addEdge(0, 1,1);
		graph.addEdge(2,3,3);
		graph.addEdge(2,4,6);
		graph.addEdge(1,3,2);
		graph.addEdge(0,3,1);
		graph.addEdge(3,4,6);
		graph.addEdge(0,2,8);
		graph.addEdge(4,5,7);
		
		graph.printEdges();
		
		//DepthFirst df = new DepthFirst(graph, 0);
		//df.dfs(graph, 0);
		System.out.println("EdgeTo");
		//df.printEdgeTo();
		
		//System.out.println("TopologicalSort");
		//df.topologicalSort(graph, graph.V());
		//System.out.print(graph.checkPathExist(0,5));

	}
	

	
	public void addEdge(int v1, int v2, int w){
		adj.get(v1).put(v2,w);
		//adj.get(v2).put(v1,w);
		//adj.get(w).add(v);
	}
	
	public void addDiGrapghEdge(int v1, int v2, int w){
		adj.get(v1).put(v2,w);

	}
	
	
	public int V(){
		
		return v;
	}
	
	public void printEdges(){
		for(Map<Integer, Integer> node:adj){
			Iterator<Integer> itr = node.keySet().iterator();
			while(itr.hasNext()){
				Integer key = itr.next();
				System.out.println(adj.indexOf(node)+"----"+key+", weight = "+node.get(key));
			}
		}
	}

	/*public boolean checkPathExist(int a, int b){
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
	}*/

}
