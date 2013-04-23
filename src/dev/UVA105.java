/**
 * Project Name:UVA
 * File Name:UVA105.java
 * Package Name:dev
 * Created Date:2012-12-30����3:35:24
 * Modified Date: 2012-12-30����3:35:24
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package dev;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName:UVA105 <br/>
 * date: 2012-12-30����3:35:24 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */

class Tree{
	//�߶���������������������λ��
	public int L,R,mid;
	//������һ����ĸ߶ȣ���ʼֵΪ0
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
		//�����߶�������Ҫ�Ŀռ��������账�����߶γ��ȵ�3�����ң����Կ�4����С������
		for(int i=0;i<4*10000;i++){
			nodes[i]=new Tree();
		}
		//�����߶�������ʼ��
		buildTree(1,10000,1);
		//�������룬�����߶���
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			//l,h,r����ֵ�ֱ��Ӧ��߽�㣬�߶ȣ��ұ߽��
			int l=cin.nextInt();
			int h=cin.nextInt();
			int r=cin.nextInt();
			//���в������,�Ӹ��ڵ㿪ʼ��ѯ
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
			//����ΪҶ�ӽڵ㣬��ݹ齨����������
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
			//��ǰ�����Ѿ�������ķ�Χ,�жϸ߶��Ƿ���Ҫ����
			if(nodes[pos].h<h){
				nodes[pos].h=h;
			}	
		}
		if(r<nodes[pos].mid){
			//��ѯ������
			insertTree(l,r,h,2*pos);
		}else{
			if(l>nodes[pos].mid){
				//��ѯ������
				insertTree(l,r,h,2*pos+1);
			}else{
				//�����������ж��У���ѯ��������
				insertTree(l,nodes[pos].mid,h,2*pos);
				insertTree(nodes[pos].mid,r,h,2*pos+1);
			}
		} 
			
		
	}

	
}
