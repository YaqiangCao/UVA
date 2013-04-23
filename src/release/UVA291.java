/**
 * Project Name:UVA
 * File Name:UVA291.java
 * Package Name:dev
 * Created Date:2012-12-21����6:30:52
 * Modified Date: 2012-12-21����6:30:52
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

/**
 * ClassName:UVA291 <br/>
 * date: 2012-12-21����6:30:52 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA291 {

	/**
	 * main:<br/>
	 * @param args
	 */
	//��¼������·��
	static int[] save=new int[9];
	//ͼ����ͨ�ԣ���ͨΪ1������Ϊ0���Լ����Լ�Ϊ0
	static int[][] G=new int[6][6];
	
	public static void main(String[] args) {		//����ͼ����ͨ��
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
	
	//�������������s����ʼ�����㣬n���յ㣬d������¼�������ڼ������ˣ�e��ʾ����
	private static void dfs(int s, int n, int d, int e){
		//�������ĵ����Ŀ���ڱ�����1������������˳��������
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
				//��ͣ�����������ֱ���ҵ����е㣬Ҫô�Ҳ���
				dfs(i,n,d+1,e);
				G[s][i]=1;
				G[i][s]=1;
			}
		}
	}
}
