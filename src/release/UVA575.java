/**
 * Project Name:UVA
 * File Name:UVA575.java
 * Package Name:dev
 * Created Date:2012-12-31обнГ9:15:49
 * Modified Date: 2012-12-31обнГ9:15:49
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.Scanner;

/**
 * ClassName:UVA575 <br/>
 * date: 2012-12-31обнГ9:15:49 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA575 {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String line=cin.nextLine();
			if (line.equals("0")){
				return;
			}
			long result=0;
			for(int i=0;i<line.length();i++){
				int tmp=Integer.parseInt(line.charAt(i)+"");
				long r=(long) Math.pow(2, line.length()-i);
				result+=tmp*(r-1);
			}
			System.out.printf("%d\n", result);
		}
		
	}

}
