package graph;

import java.util.List;
import java.util.Stack;

public class DepthFirst {

	private int s;
	private boolean [] marked ;
	private int [] edgeTo;
	private Stack<Integer> stack;
	
	public DepthFirst(Graph G, int s) {
		marked = new boolean[G.v];
		edgeTo = new int[G.v];
		stack = new Stack<>();
		for(int i = 0 ; i <edgeTo.length; i ++){
			edgeTo[i] =-1;
		}
		
	}
	
	public void dfs(Graph G, int v){
		if(marked[v]) return;
		marked[v] = true;

		System.out.println(v);
		
		for(Integer w : G.adj(v) ){
			if(!marked[w]){
				dfs(G, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public void printEdgeTo()
	{
		for(int i =0;i<edgeTo.length ; i++){
			System.out.println(edgeTo[i]);

		}
	}
	
	public void topologicalSort(Graph G, int v){
		for(int i =0;i<G.V();i++){
			postOrder(G, i);
		}
		
	}
	
	private void postOrder(Graph G, int v){
		if(marked[v]) return;
		for(Integer w:G.adj(v)){
			if(!marked[w]){
				postOrder(G, w);		
			}
		}
		System.out.println(" vertex = "+v);
		marked[v] = true;
	}
}
