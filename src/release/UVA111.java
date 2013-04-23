/**
 * Project Name:UVA
 * File Name:UVA111.java
 * Package Name:dev
 * Created Date:2013-1-17下午4:39:00
 * Modified Date: 2013-1-17下午4:39:00
 * Copyright (c) 2013, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ClassName:UVA111 <br/>
 * date: 2013-1-17下午4:39:00 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA111 {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		//读入总共N个记录待处理，这个程序其实用不上
		int N=Integer.parseInt(cin.nextLine());
		//读入正确的事件序列
		String[] events=cin.nextLine().split(" ");
		//例如4 3 2 1 代表的是第一个事件排序第4，用ABCD来表示1234事件，则正确的排序是DBCA
		int[] eventsConverted=convert(events);
		Hashtable<Integer, Integer> rank=new Hashtable();
		for(int i=0;i<eventsConverted.length;i++){
			rank.put(eventsConverted[i], i);
		}
		while(cin.hasNext()){
			//读入一个序列
			String[] toScore=cin.nextLine().split(" ");
			//转变成与正确序列相对应的排序
			int beforeRank[]=convert(toScore);
			int toRank[]=new int[toScore.length];
			for(int i=0;i<beforeRank.length;i++){
				toRank[i]=rank.get(beforeRank[i]);
			}
			
			//求最长上升子序列
			getScore(toRank);
		}
	}

	/**
	 * convert:<br/>
	 * @param events
	 * @return
	 */
	private static int[] convert(String[] events) {
		int converted[]=new int[events.length];
		for(int i=0;i<events.length;i++){
			//System.out.printf("%d %s     ", i,events[i]);
			converted[Integer.parseInt(events[i])-1]=i;
		}
		return converted;
	}

	/**
	 * getScore:<br/>
	 * @param toRank
	 */
	private static void getScore(int[] toRank) {
		//使用TreeSet这个结构来存储已有的最长序列
		TreeSet<Integer> lal=new TreeSet();
		//初始化
		lal.add(-1);
		for(int i=0;i<toRank.length;i++){
			//当前值比栈里面的最大值大，表明最长上升序列还没有结束，加入这一值
			if(toRank[i]<lal.last()){
				//取出比这一值大的值，加入这一值
				int a=lal.higher(toRank[i]);
				lal.remove(a);
			}
			lal.add(toRank[i]);
		}
		System.out.println(lal.size()-1);
	}

}
