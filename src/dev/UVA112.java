package dev;

import java.util.Scanner;


class BinaryTree {
	private Node root;
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
	
	public void BinaryTree(){
		root=null;
	}
	

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
		return node;
	}
	
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
}



public class UVA112 {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
	}
}
