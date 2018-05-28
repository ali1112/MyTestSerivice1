package graph;

import java.util.LinkedList;

public class BreadthFirst {
	private int s;
	private boolean [] marked ;
	private int [] edgeTo;
	
	public BreadthFirst(Graph G, int s){
		marked = new boolean[G.v];
		edgeTo = new int[G.v];
		for(int i = 0 ; i <edgeTo.length; i ++) edgeTo[i] =-1;


	}
	
	public void bfs(Graph G, int v){
		//if(marked[v]) return;
		System.out.println(v);
		//marked[v] = true;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(v);
		
		while(!list.isEmpty()){
			for(Integer w:G.adj(v)){
				if(!marked[w]){
					list.add(w);
				}
			}
		}
		
	}
}
