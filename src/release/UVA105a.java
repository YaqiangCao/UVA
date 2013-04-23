/**
 * Project Name:UVA
 * File Name:UVA105a.java
 * Package Name:dev
 * Created Date:2012-12-30����9:05:09
 * Modified Date: 2012-12-30����9:05:09
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName:UVA105a <br/>
 * date: 2012-12-30����9:05:09 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA105a {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static int[] nodes=new int[10000+1];
	
	public static void main(String[] args) {
		for(int i=0;i<nodes.length;i++){
			nodes[i]=0;
		}
		Scanner cin=new Scanner(System.in);
		//������¼�߽�
		int minx=Integer.MAX_VALUE;
		int maxx=-1;
		while(cin.hasNext()){
			//l,h,r����ֵ�ֱ��Ӧ��߽�㣬�߶ȣ��ұ߽��
			int l=cin.nextInt();
			int h=cin.nextInt();
			int r=cin.nextInt();
			if (l<minx){
				minx=l;
			}
			if(r>maxx){
				maxx=r;
			}
			//��ֵ����
			setNodes(l,h,r);
//			callResult(minx,maxx);
		}
		//ͳ�ƽ��
		callResult(minx,maxx);
	}
	/**
	 * callResult:<br/>
	 * @param minx
	 * @param maxx
	 */
	private static void callResult(int minx, int maxx) {
		ArrayList result=new ArrayList();
		result.add(minx);
		int tmp=nodes[minx];
		for(int i=minx+1;i<=maxx+1;i++){
			if(nodes[i]==tmp){
				continue;
			}else{
				result.add(tmp);
				result.add(i);
				tmp=nodes[i];
			}
		}
		result.add(0);
		for(int i=0;i<result.size();i++){
			if(i!=result.size()-1){
				System.out.printf("%d ", result.get(i));
			}else{
				System.out.printf("%d\n", result.get(i));
			}
		}
	}
	/**
	 * setNodes:<br/>
	 * @param l
	 * @param h
	 * @param r
	 */
	private static void setNodes(int l, int h, int r) {
		for(int i=l;i<r;i++){
			if(h>nodes[i]){
				nodes[i]=h;
			}
		}
	}

}
