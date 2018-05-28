package misc;

public class TreeNode<Data extends Comparable<Data>> implements Comparable<TreeNode<Data>>{

	Data data;
	TreeNode<Data> leftChild;
	TreeNode<Data> reightChild;
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public TreeNode(Data data){
		this.data = data;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((reightChild == null) ? 0 : reightChild.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (reightChild == null) {
			if (other.reightChild != null)
				return false;
		} else if (!reightChild.equals(other.reightChild))
			return false;
		return true;
	}
	@Override
	public int compareTo(TreeNode<Data> o) {
		if(o == null){
			return -1;
		}
		return this.data.compareTo(o.data);
	}


	
}
