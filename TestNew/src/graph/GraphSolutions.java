package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by msharafat on 1/31/18.
 */
public class GraphSolutions {

    public static void main(String [] args){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> node0 = new ArrayList<>();
        node0.add(1);

        ArrayList<Integer> node1 = new ArrayList<>();
        node1.add(2);
        node1.add(3);

        ArrayList<Integer> node2 = new ArrayList<>();
        node2.add(3);
        node2.add(5);


        ArrayList<Integer> node3 = new ArrayList<>();
        node3.add(1);


        ArrayList<Integer> node4 = new ArrayList<>();
        node4.add(5);


        ArrayList<Integer> node5 = new ArrayList<>();

        list.add(node0);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);


        GraphSolutions g = new GraphSolutions();
        List<Integer> list2 = g.topologicalSort(list);

    }
    public List<Integer> topologicalSort(ArrayList<ArrayList<Integer>> list){
        int [] a = new int[list.size()];
        for(int k=0;k<list.size();k++){
            a[k] = 0;
        }
        Stack<Integer> s = new Stack<>();
        List<Integer> sortedList = new ArrayList<>();
        s.push(0);
        while(!s.isEmpty()){
            Integer node = s.pop();
            a[node] = 1;
            sortedList.add(node);
            int i =0;
            List<Integer> adjNodes = list.get(node);
            while(!adjNodes.isEmpty() && i < adjNodes.size()){
                Integer adjNode = adjNodes.get(i++);
                if(a[adjNode] == 0){
                    s.push(adjNode);
                    a[adjNode] = 1;
                }
            }

        }
        Collections.reverse(sortedList);
        return sortedList;
    }
}
