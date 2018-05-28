package misc;

public class BinarySearcjTree<Data extends Comparable<Data>> {

	TreeNode<Data> root;
	
	/*public BinarySearcjTree(TreeNode root){
		
		this.root = root;
	}
	*/
	public BinarySearcjTree() {
	}

	public static void main(String []args){
		BinarySearcjTree<Integer> tree = new BinarySearcjTree<>();
//		tree.insert(4);
//		tree.insert(2);
//		tree.insert(5);
//		tree.insert(1);
//		tree.insert(11);
//		tree.insert(16);
//		tree.insert(12);
//		tree.insert(15);

//		tree.insert(100);
//		tree.insert(4);
//		tree.insert(200);
//		tree.insert(3);
//		tree.insert(250);
//		tree.insert(350);
//		tree.insert(2);
//		tree.insert(1);
		tree.longestConsecutive(new int[]{100,4,200,3,250,350,2,1,6});

		/*
					4
				2		5
			1				11
								16
							12
								15
		 */
		
		tree.inOrderTraversal();

		//TreeWidth treeWidth = tree.getTreeWidth(tree.getRoot());

		//Integer n = tree.inorderSuccessor(11);
		//System.out.println("left = "+treeWidth.left);
		//System.out.println("right = "+treeWidth.right);




	}

	public TreeNode getRoot(){
		return root;
	}
	public void insert(Data data){
		if(data == null){
			return;
		}
		
		TreeNode<Data> node = new TreeNode<>(data);
		if(root == null){
			root = new TreeNode<Data>(data);
			
		}
	
		else{
			TreeNode<Data> newRoot = root;
			TreeNode<Data> oldRoot = newRoot;

			while(newRoot != null){
				oldRoot = newRoot;
				if(newRoot.compareTo(node) > 0){
					newRoot = newRoot.leftChild;
					
				}
				
				else if(newRoot.compareTo(node) <= 0){
				
					newRoot = newRoot.reightChild;
					
				}
				
			}
			
			if(oldRoot.compareTo(node) > 0){
				oldRoot.leftChild = node;
			}
			else{
				oldRoot.reightChild = node;
			}
			
		}
	}

	public int longestConsecutive(final int[] A) {
		BinarySearcjTree<Integer> tree = new BinarySearcjTree<>();

		for(int i=0;i<A.length;i++){
			tree.insert(A[i]);
		}
		TreeNode root= tree.getRoot();
		int n = getLongestConsecutive(root);
		System.out.print(n);
		return n;
	}

	public Integer getLongestConsecutive(TreeNode<Integer> node){
		if(node == null) return 1;
		Integer n1 = getLongestConsecutive(node.leftChild);
		Integer n2 =  getLongestConsecutive(node.reightChild);
		int n;
		Integer diff=0;
		Integer diff2=0;

		if(node.leftChild!=null){
			 diff = Math.abs(Math.abs(node.leftChild.data) - Math.abs(node.data));

			if(diff == 1 ) n1++;
		}

		if(node.reightChild!=null){
			 diff2 = Math.abs(Math.abs(node.reightChild.data) - Math.abs(node.data));

			if(diff2 == 1 ){
				n2++;
			}
		}
		if(diff == diff2 && diff ==1){
			return n1+n2 -1;
		}
 		return n1>n2?n1:n2;


	}
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
	
	public void inOrderTraversal(TreeNode<Data> node){
		if(node == null){
			return ;
		}
		inOrderTraversal(node.leftChild);
		visit(node);
		inOrderTraversal(node.reightChild);	
		
	}
	
	public TreeNode<Data> inOrderSuccessor(TreeNode<Data> treeNode, Data key){
		
		if(treeNode == null){
			return  null;
		}
		
		System.out.println("On Node : "+treeNode.data);
		
		if(treeNode.data.compareTo(key) == 0){
			while(treeNode.reightChild != null){
				treeNode = treeNode.reightChild;
			}
			
			while(treeNode.leftChild != null){
				treeNode = treeNode.leftChild;
			}
			
			return treeNode;
		}
					
		TreeNode<Data> node1= inOrderSuccessor(treeNode.leftChild, key);
		visit(treeNode);
		TreeNode<Data> node2=  inOrderSuccessor(treeNode.reightChild, key);
			
		return (node1 == null) ? node2:node1;

		
			
		
	}
	public Data inorderSuccessor(Data key){
		
		return inOrderSuccessor(root,key).data;
				
		
	}
	
	public void visit(TreeNode node){
		if(node == null){
			return;
		}
		System.out.println(node.getData());
	}

	public TreeWidth getTreeWidth(TreeNode node){
		if(node == null){
			return null;
		}

		if(node.leftChild == null && node.reightChild == null){
			return new TreeWidth(1,1);
		}

		TreeWidth left = getTreeWidth(node.leftChild);
		TreeWidth right = getTreeWidth((node.reightChild));

		TreeWidth treeWidth = new TreeWidth(0,0);

		if(left !=null && right !=null){
			treeWidth.left = left.left > right.left ? left.left+1:right.left+1;
			treeWidth.right = left.right > right.right ? left.right +1:right.right +1;
		}
		else if(left!=null){
			treeWidth.left = left.left+1;
		}

		else if(right!=null){
			treeWidth.right = right.right+1;
		}

		return treeWidth;

	}
}
