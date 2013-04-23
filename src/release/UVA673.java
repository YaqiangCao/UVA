/**
 * Project Name:UVA
 * File Name:UVA673.java
 * Package Name:dev
 * Created Date:2012-12-31下午8:15:06
 * Modified Date: 2012-12-31下午8:15:06
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName:UVA673 <br/>
 * date: 2012-12-31下午8:15:06 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA673 {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int n=Integer.parseInt(cin.nextLine());
		for(int i=0;i<n;i++){
			String line=cin.nextLine().trim();
			//使用栈来完成括号匹配
			if (isMatch(line)){
				System.out.printf("Yes\n");
			}else{
				System.out.printf("No\n");
			}
			
		}

	}

	/**
	 * isMatch:<br/>
	 * @param line
	 * @return
	 */
	private static boolean isMatch(String line) {
		Stack<Character> sk=new Stack();
		for(int i=0;i<line.length();i++){
			if(line.charAt(i)=='('){
				sk.push('(');
			}
			if(line.charAt(i)==')'){
				if((!sk.isEmpty()) && sk.pop()=='('){
					continue;
				}else{
					return false;
				}
			}
			if(line.charAt(i)=='['){
				sk.push('[');
			}
			if(line.charAt(i)==']'){
				if((!sk.isEmpty()) && sk.pop()=='['){
					continue;
				}else{
					return false;
				}
			}
			
		}
		if(sk.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

}
