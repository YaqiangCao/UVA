/**
 * Project Name:UVA
 * File Name:UVA103.java
 * Package Name:dev
 * Created Date:2012-8-29下午5:07:56
 * Modified Date: 2012-8-29下午5:07:56
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * ClassName:UVA103 <br/>
 * date: 2012-8-29下午5:07:56 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA103 {
	public static void main(String[] args) throws IOException {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			//k is the boxes number and n is the dimension of each box
			int k=cin.nextInt();
			int n=cin.nextInt();
			int[][] boxes=new int[k][n];
			for(int i=0;i<k;i++){
				for(int j=0;j<n;j++){
					boxes[i][j]=cin.nextInt();
				}
				//sort the dimensions of every box
				Arrays.sort(boxes[i]);
			}
			//call the function for calculation and presentation the result
			stackingBoxes(boxes);
		}
	}

	/**
	 * stackingBoxes:<br/>
	 * @param boxes
	 */
	private static void stackingBoxes(int[][] boxes) {
		//prepare the original rank of boxes and sorting the boxes
		ArrayList originalBoxes=new ArrayList();
		for(int i=0;i<boxes.length;i++){
			originalBoxes.add(boxes[i]);
		}
		for(int i=0;i<boxes.length-1;i++){
			for(int j=i+1;j<boxes.length;j++){
				int flag=1;
				for(int k=0;k<boxes[0].length;k++){
					if(boxes[j][k]<boxes[i][k]){
						flag=0;
						break;
					}else{
						//苦逼点，之前就是没有加这句，然后就是k会走到最后
						if(boxes[j][k]>boxes[i][k]){
							break;
						}
					}
				}
				if(flag==1){
					continue;
				}else{
					int[] temp=boxes[j];
					boxes[j]=boxes[i];
					boxes[i]=temp;
				}
			}
		}
		//the dynamic programming value array, length of that nesting string
		int[] dp=new int[boxes.length];
		//set every element in dp to 0,except the first one, it's set to 1
		Arrays.fill(dp, 0);
		dp[0]=1;
		//prev is the last position of the latest LIS
		int[] prev=new int[boxes.length];
		Arrays.fill(prev, -1);
		//the Longest Increasing Subsequence algorithm, the simple one, O(n*n)
		for(int i=1;i<dp.length;i++){
			int ans=dp[i];
			for(int j=0;j<i;j++){
				if(compareBox(boxes[i],boxes[j]) && dp[j]>ans){
					ans=dp[j];
					//add the current location
					prev[i]=j;
				}
			}
			dp[i]=ans+1;
		}
		int ans=0,maxDpIndex=0;
		for(int i=0;i<dp.length;i++){
			//there may be multiple max length, take the last one;
			if(dp[i]>ans){
				ans=dp[i];
				maxDpIndex=i;
			}
		}
		String result="\n";
		while(maxDpIndex!=-1){
			result=originalBoxes.indexOf(boxes[maxDpIndex])+1+" "+result;
			maxDpIndex=prev[maxDpIndex];
		}
		result=ans+"\n"+result;
		System.out.printf("%s",result);
	}


	/**
	 * compareBox:<br/>
	 * @param is
	 * @param is2
	 * @return
	 */
	private static boolean compareBox(int[] a, int[] b) {
		// compare the boxes, if all dimension in box A are lower than or equal of box B's, return true
		int flag=0;
		for(int i=0;i<a.length;i++){
			if(a[i]>b[i]){
				flag=1;
			}else{
				flag=0;
			}
			if(flag==0){
				break;
			}
		}
		if(flag==1){
			return true;
		}else{
			return false;
		}
	}

}
