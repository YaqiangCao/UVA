/**
 * Project Name:UVA
 * File Name:UVA291.java
 * Package Name:dev
 * Created Date:2012-12-21下午6:30:52
 * Modified Date: 2012-12-21下午6:30:52
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

/**
 * ClassName:UVA291 <br/>
 * date: 2012-12-21下午6:30:52 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA291 {

	/**
	 * main:<br/>
	 * @param args
	 */
	//记录搜索的路径
	static int[] save=new int[9];
	//图的连通性，联通为1，否则为0，自己和自己为0
	static int[][] G=new int[6][6];
	
	public static void main(String[] args) {		//定义图的连通性
		G[1][2]=G[2][1]=1;
		G[1][3]=G[3][1]=1;
		G[1][5]=G[5][1]=1;
		G[2][3]=G[3][2]=1;
		G[2][5]=G[5][2]=1;
		G[3][4]=G[4][3]=1;
		G[3][5]=G[5][3]=1;
		G[4][5]=G[5][4]=1;
		dfs(1,5,0,8);
	}
	
	//深度优先搜索，s是起始搜索点，n是终点，d用来记录搜索到第几个点了，e表示边数
	private static void dfs(int s, int n, int d, int e){
		//搜索到的点的数目等于边数加1，搜索结束，顺序输出结果
		if (d==e){
			for (int i=0;i<e;i++){
				System.out.printf("%d",save[i]);
			}
			System.out.printf("%d\n",s);			
			return;
		}
		save[d]=s;
		for (int i=1;i<=n;i++){
			if (G[s][i]==1){
				G[s][i]=0;
				G[i][s]=0;
				//不停地深度搜索，直到找到所有点，要么找不完
				dfs(i,n,d+1,e);
				G[s][i]=1;
				G[i][s]=1;
			}
		}
	}
}
