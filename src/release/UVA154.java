/**
 * Project Name:UVA
 * File Name:UVA154.java
 * Package Name:dev
 * Created Date:2012-12-21下午9:20:13
 * Modified Date: 2012-12-21下午9:20:13
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName:UVA154 <br/>
 * date: 2012-12-21下午9:20:13 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA154 {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin=new Scanner(System.in);
		ArrayList<Hashtable> cities=new ArrayList();
		while(cin.hasNext()){
			String line=cin.nextLine();
			//判断是否到了文件结束,是的话结束整个程序
			if (line.startsWith("#")){
				return;
			}else{
				if(line.startsWith("e")){
					//a block of cities is finished, call the sub-function to do the work and clear the arraylist container
					alloca(cities);
					cities.clear();
				}
				else{
					//对每一行含有颜色和垃圾类别字符串信息进行处理，全部取小写，去除空格，按,切分后再按/切分，去除空格，颜色为key，垃圾类型为value，做成hash表，加入cities链表中，准备喂给函数
					line=line.toLowerCase().trim();
					String[] tokens=line.split(",");
					Hashtable<String,String> city=new Hashtable();
					for(int i=0;i<tokens.length;i++){
						String[] crs=tokens[i].trim().split("/");
						city.put(crs[0].trim(), crs[1].trim());
					}
					cities.add(city);
				}
			}
		}
	}

	/**
	 * alloca:<br/>
	 * @param cities
	 */
	private static void alloca(ArrayList<Hashtable> cities) {
		int id = 0,minvote = Integer.MAX_VALUE;
		for(int i=0;i<cities.size();i++){
			Hashtable host=cities.get(i);
			int votes=0;
			for(int j=0;j<cities.size();j++){
				Hashtable visit=cities.get(j);
				//比较host的各个键值和visit的，不同的话加1，表明是需要重排的项
				for (Iterator it=host.keySet().iterator();it.hasNext();){
					String key=(String) it.next();
					String p1=(String) host.get(key);
					String p2=(String) visit.get(key);
					if (!p1.equals(p2)){
						votes=votes+1;
					}
				}
			}
			if(votes<minvote){
				id=i+1;
				minvote=votes;
			}
		}
		System.out.printf("%d\n",id);
	}

}
