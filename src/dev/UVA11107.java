/**
 * Project Name:UVA
 * File Name:UVA11107.java
 * Package Name:dev
 * Created Date:2013-4-14下午7:59:40
 * Modified Date: 2013-4-14下午7:59:40
 * Copyright (c) 2013, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package dev;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * ClassName:UVA11107 <br/>
 * date: 2013-4-14下午7:59:40 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA11107 {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N=cin.nextInt();
			if(N==0){
				return;
			}
			ArrayList<String> lines=new ArrayList();
			for(int i=1;i<=N;i++){
				String line=cin.next();
				line=line.toLowerCase().trim();
				lines.add(line);
			}
			findls(lines,N);
		}

	}

	private static void findls(ArrayList<String> lines, int n) {
		Hashtable<String,Integer> stat=new Hashtable();
		for(String line:lines){
		}
	}

}




