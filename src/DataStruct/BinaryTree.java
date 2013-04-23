package DataStruct;
//reference:http://cslibrary.stanford.edu/110/BinaryTrees.html#java
class BinaryTree {
	private Node root;
	
	/*
	 * Node
	 * The binary tree is built using this nested node class.
	 * Each node stores on data element, left and right sub-tree.
	 * The node just be used for storage; it does not have any methods.
	 */
	private static class Node{
		Node left;
		Node right;
		int data;
		
		Node(int newData){
			left=null;
			right=null;
			data=newData;		
		}
	}
	
	/*Create an empty binary tree --a null root pointer
	 */
	public void BinaryTree(){
		root=null;
	}
	
	/* Return true if the given target is in the binary tree.
	 * 
	 */
	public boolean lookup(int data){
		return(lookup(root,data));
	}
	
	private boolean lookup(Node node,int data){
		if(node==null){
			return(false);
		}
		if(data==node.data){
			return(true);
		}
		else if(data<node.data){
			return(lookup(node.left,data));
		}
		else{
			return(lookup(node.right,data));
		}
	}
	
	/*Inserts the given data into the binary tree.
	 * 
	 */
	public void insert(int data){
		root=insert(root,data);
	}
	private Node insert(Node node,int data){
		if(node==null){
			node=new Node(data);
		}else{
			if(data<=node.data){
				node.left=insert(node.left,data);
			}else{
				node.right=insert(node.right,data);
			}
		}
		return node; //in any case, return hte new pointer to the caller
	}
	
	//2.size() Solution
	public int size(){
		return(size(root));
	}
	private int size(Node node){
		if(node==null){
			return 0;
		}else{
			return size(node.left)+1+size(node.right);
		}
	}
	
	//*3.maxDepth() Solution
	public int maxDepth(){
		return maxDepth(root);
	}
	private int maxDepth(Node node){
		if(node==null){
			return 0;
		}else{
			int lDepth=maxDepth(node.left);
			int rDepth=maxDepth(node.right);
			return Math.max(lDepth,rDepth)+1;
		}
	}
	
	//*4.minValue() Solution
	public int minValue(){
		return minValue(root);
	}
	private int minValue(Node node){
		Node current=node;
		while(current.left!=null){
			current=current.left;
		}
		return current.data;
	}
	
	//*5.printTree() Solution
	public void printTree(){
		printTree(root);
		System.out.println();
	}
	private void printTree(Node node){
		if(node==null){
			return;
		}
		printTree(node.left);
		System.out.print(node.data+" ");
		printTree(node.right);
	}
	
	//*6.printPostorder() Solution
	public void printPostorder(){
		printPostorder(root);
		System.out.println();
	}
	private void printPostorder(Node node){
		if(node==null){
			return;
		}
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data+" ");
	}
	
	//*7.hasPathSum() Solution
	public boolean hasPathSum(int sum){
		return hasPathSum(root,sum);
	}
	private boolean hasPathSum(Node node,int sum){
		if(node==null){
			return sum==0;
		}else{
			int subSum=sum-node.data;
			return (hasPathSum(node.left,subSum) || hasPathSum(node.right,subSum));
		}
	}
	
	//8.printPaths() Solution
	public void printPaths(){
		int[] path=new int[10000];
		printPaths(root,path,0);
	}
	private void printPaths(Node node,int[] path, int pathLen){
		if(node==null){
			return;
		}
		path[pathLen]=node.data;
		pathLen++;
		if(node.left==null && node.right==null){
			printArray(path,pathLen);
		}else{
			printPaths(node.left,path,pathLen);
			printPaths(node.right,path,pathLen);
		}
		
	}
	private void printArray(int[] ints,int len){
		int i;
		for(i=0;i<len;i++){
			System.out.print(ints[i]+" ");
		}
		System.out.println();
	}
	
	//*9.mirror() Solution
	public void mirror(){
		mirror(root);
	}
	private void mirror(Node node){
		if (node !=null) {
			//do the sub-trees
			mirror(node.left);
			mirror(node.right);
			//swap the left/right pointers
			Node temp=node.left;
			node.left=node.right;
			node.right=temp;
		}
	}

	//10.doubleTree() Solution, Changes the tree by inserting a duplicate node on each nodes's .left
	public boolean sameTree(BinaryTree other){
		return sameTree(root,other.root);
	}
	private boolean sameTree(Node a, Node b){
		if (a==null && b==null) {
			return true;
		}else{
			if(a!=null && b!=null){
				return(
					a.data==b.data &&
					sameTree(a.left,b.left) &&
					sameTree(a.right,b.right)

					);
			}else{
				return false;
			}
		}
	}

	//11.countTrees() Solutions, for the key values 1...numKeys, how many structurally unique binary search trees are possible that store those keys?
	public static int countTrees(int numKeys) {
		if(numKeys<=1){
			return 1;
		}else{
			int sum=0;
			int left,right,root;
			for(root=1;root<=numKeys;root++){
				left=countTrees(root-1);
				right=countTrees(numKeys-root);
				sum+=left*right;
			}
			return sum;
		}
	}
	
	//12.isBST() Solutions, to tests if a tree meets the conditions to be a binary search tree(BST)
	public boolean isBST(){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean isBST(Node node,int min,int max){
		if(node==null){
			return true;
		}else{
			boolean leftOk=isBST(node.left,min,node.data);
			if (!leftOk) {
					return false;
			}
			boolean rightOk=isBST(node.right,node.data+1,max);
			return rightOk;
		}
	}
}
