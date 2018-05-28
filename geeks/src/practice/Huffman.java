package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by msharafat on 3/13/18.
 */
public class Huffman {

    Comparator<HuffmanRootNode> comparator = new MyComparator();

    PriorityQueue<HuffmanRootNode> minHeap = new PriorityQueue<HuffmanRootNode>(7, comparator);


    public static void main(String[] args){
        HuffManNode node = new HuffManNode('a', 5);
        HuffManNode node2 = new HuffManNode('b', 9);
        HuffManNode node3 = new HuffManNode('c', 12);
        HuffManNode node4 = new HuffManNode('d', 13);
        HuffManNode node5 = new HuffManNode('e', 16);
        HuffManNode node6 = new HuffManNode('f', 45);
        //HuffManNode node7 = new HuffManNode('g', 54);

        HuffmanRootNode rootNode = new HuffmanRootNode( 'a', 5);
        HuffmanRootNode rootNode2 = new HuffmanRootNode( 'b', 9);
        HuffmanRootNode rootNode3 = new HuffmanRootNode( 'c',12);
        HuffmanRootNode rootNode4 = new HuffmanRootNode( 'd',13);
        HuffmanRootNode rootNode5 = new HuffmanRootNode('e',16);
        HuffmanRootNode rootNode6 = new HuffmanRootNode( 'f',45);
     //   HuffmanRootNode rootNode7 = new HuffmanRootNode('g',54);

        Huffman huffman = new Huffman();
        huffman.insert(rootNode);
        huffman.insert(rootNode2);
        huffman.insert(rootNode3);
        huffman.insert(rootNode4);
        huffman.insert(rootNode5);
        huffman.insert(rootNode6);
      //  huffman.insert(rootNode7);
        huffman.build();


    }

    public void build(){
        while(minHeap.size() > 1){
            HuffmanRootNode rootNode1 = minHeap.poll();
            HuffmanRootNode rootNode2 = minHeap.poll();
            HuffmanRootNode rootNode = new HuffmanRootNode('$', rootNode1.f + rootNode2.f);
            rootNode.left = new HuffManNode(rootNode1.c,rootNode1.f);
            rootNode.left.left = rootNode1.left;
            rootNode.left.right = rootNode1.right;

            rootNode.right =  new HuffManNode(rootNode2.c,rootNode2.f);;

            rootNode.right.left = rootNode2.left;
            rootNode.right.right = rootNode2.right;

            this.insert(rootNode);
            System.out.println("rootNode 1="+rootNode1.f);
            System.out.println("rootNode 2="+rootNode2.f);
            System.out.println("node ="+rootNode.f);


        }
        printHuffmanCode();

    }

    public void printHuffmanCode(){
        int [] a = new int[7];
        int k = 0;
        HuffmanRootNode rootNode = minHeap.peek();
        HuffManNode node = new HuffManNode('$',rootNode.f);
        node.left = rootNode.left;
        node.right=rootNode.right;
        traverse(node,a,0);
    }
    public void traverse(HuffManNode node, int a[], int k){
        if(node.left == null && node.right==null){
            System.out.println();
            System.out.print(node.c+"   ");
            int i =0;
            while(i < k){
                System.out.print(a[i++]);
            }
        }
        if(node.left!= null){
            a[k] = 0;
            traverse(node.left,a,k+1);
        }
        if(node.right!=null){
            a[k] = 1;
            traverse(node.right,a,k+1);
        }
    }

    public void insert(HuffmanRootNode node){
        minHeap.add(node);
    }

    private class MyComparator implements Comparator<HuffmanRootNode>{
        @Override
        public int compare(HuffmanRootNode o1, HuffmanRootNode o2) {
            return o1.f - o2.f;
        }
    }

}
