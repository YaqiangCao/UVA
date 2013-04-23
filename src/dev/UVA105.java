/**
 * Project Name:UVA
 * File Name:UVA105.java
 * Package Name:dev
 * Created Date:2012-12-30下午3:35:24
 * Modified Date: 2012-12-30下午3:35:24
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package dev;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName:UVA105 <br/>
 * date: 2012-12-30下午3:35:24 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */

class Tree{
	//线段树的左子树和右子树的位置
	public int L,R,mid;
	//代表这一区域的高度，初始值为0
	public int h=0;
}

public class UVA105 {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static Tree[] nodes=new Tree[4*10000];
	public static int pos=0;
	public static void main(String[] args) {
		//建立线段树所需要的空间大概是所需处理的最长线段长度的3倍左右，所以开4倍大小的数组
		for(int i=0;i<4*10000;i++){
			nodes[i]=new Tree();
		}
		//建立线段树，初始化
		buildTree(1,10000,1);
		//读入输入，更新线段树
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			//l,h,r三个值分别对应左边界点，高度，右边界点
			int l=cin.nextInt();
			int h=cin.nextInt();
			int r=cin.nextInt();
			//进行插入操作,从根节点开始查询
			insertTree(l,r,h,1);
			int[] d={l,h,r};
		}
	}
	/**
	 * buildTree:<br/>
	 * @param i
	 * @param j
	 * @return
	 */
	private static void buildTree(int l, int r,int pos) {
		nodes[pos].L=l;
		nodes[pos].R=r;
		nodes[pos].mid=(l+r)/2;
		if(l+1!=r){
			//若不为叶子节点，则递归建立左右子树
			buildTree(l,(l+r)/2,2*pos);
			buildTree((l+r)/2,r,2*pos+1);
		}
	}
	
	/**
	 * insertTree:<br/>
	 * @param l
	 * @param r
	 * @param h
	 * @param i
	 */
	private static void insertTree(int l, int r, int h, int pos) {
		if (nodes[pos].L==l & nodes[pos].R==r){
			//当前区域已经到输入的范围,判断高度是否需要更新
			if(nodes[pos].h<h){
				nodes[pos].h=h;
			}	
		}
		if(r<nodes[pos].mid){
			//查询左子树
			insertTree(l,r,h,2*pos);
		}else{
			if(l>nodes[pos].mid){
				//查询右子树
				insertTree(l,r,h,2*pos+1);
			}else{
				//在左右子树中都有，查询左右子树
				insertTree(l,nodes[pos].mid,h,2*pos);
				insertTree(nodes[pos].mid,r,h,2*pos+1);
			}
		} 
			
		
	}

	
}
