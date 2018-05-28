package graph;

/**
 * Created by msharafat on 3/3/18.
 */
public class GraphAdjMatrix {
    int V = 9;
    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

    public static void main(String [] args){
        GraphAdjMatrix g = new GraphAdjMatrix();
        g.shortestPath(g.graph);
    }
    public void shortestPath(int [][] graph){
        int stpTree[]=new int[graph.length];
        int stpDis[] = new int[graph.length];
        int temp[] = new int[graph.length];

        stpTree[0]=graph[0][0];
        for(int i =0; i< stpTree.length;i++){
            stpDis[i] = Integer.MAX_VALUE;
            stpTree[i] = -1;
            temp[i] = -1;
        }
        stpTree[0]=1;
        stpDis[0] =0;
        //temp[0] =1;
        int node =0;
        for(int i =0; i< stpTree.length;i++){
            node = getMinDistNode(stpDis, temp);
            stpTree[i] = node;
            temp[node] =  1;

            for(int j=0;j<9;j++){
                if(graph[node][j]!= 0 && temp[j]==-1 ){
                    if(stpDis[node] + graph[node][j] < stpDis[j]){
                        stpDis[j] = stpDis[node] + graph[node][j];

                    }

                }
            }


            //temp[node] = -1;
        }


        printSPT(stpTree, stpDis);
    }

    private int getMinDistNode(int stpDist[], int [] temp){
       int min = Integer.MAX_VALUE;
       int min_index = 0;
        for(int j=0 ; j < 9 ; j++){
            if(temp[j]!= 1){
                if(min >= stpDist[j]){
                    min = stpDist[j];
                    min_index= j;
                }
            }
        }
        return min_index;
    }

    private void printSPT(int[]sptTree, int[] sptDist){
        for(int j=0 ; j < 9 ; j++){
            System.out.println(sptTree[j]+" ------- "+sptDist[sptTree[j]]);
        }

    }

}
