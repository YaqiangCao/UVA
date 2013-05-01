/**
 * Project Name:UVA
 * File Name:UVA11512.java
 * Package Name:dev
 * Created Date:Apr 30, 20137:49:54 PM
 * Modified Date: Apr 30, 20137:49:54 PM
 * Copyright (c) 2013, caoyaqiang0410@gmail.com All Rights Reserved.
 * 主要参考资料:后缀数组——处理字符串的有力工具
 */
package dev;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

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




