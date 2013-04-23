/**
 * Project Name:UVA
 * File Name:UVA118.java
 * Package Name:dev
 * Created Date:2012-12-29下午10:28:36
 * Modified Date: 2012-12-29下午10:28:36
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.Scanner;

/**
 * ClassName:UVA118 <br/>
 * date: 2012-12-29下午10:28:36 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA118 {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		//读入右上角坐标，是机器人行动的边界点
		int x=cin.nextInt()+1,y=cin.nextInt()+1;
		//标记各个点，如果有机器人在这里超过边界，则为1，否则为0
		int location[][]=new int[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				location[i][j]=0;
			}
		}
		//读入各个机器人以及他们的指令并执行
		while(cin.hasNext()){
			//机器人的坐标和初始方向
			int drx=cin.nextInt();
			int dry=cin.nextInt();
			String fx=cin.next().trim().toUpperCase();
			int[] dr={drx,dry};
			//指令
			char[] instructions=cin.next().trim().toUpperCase().toCharArray();
			//执行指令和标记坐标
			location=exec(location,x,y,dr,fx,instructions);
		}
	}


	/**
	 * exec:<br/>
	 * @param location
	 * @param robot
	 * @param instructions
	 * @return
	 */
	private static int[][] exec(int[][] location,int x,int y, int[] dr, String fx,
			char[] instructions) {
		//转向矩阵,L代表左转，R代表右转
		int[][] L={{0,1},{-1,0}};
		int[][] R={{0,-1,},{1,0}};
		//机器人动态前进方向,东南西北一次根据向量方向赋值
		int[] or={0,0};
		if (fx.equals("N")){
			or[0]=0;
			or[1]=1;
		}
		if (fx.equals("S")){
			or[0]=0;
			or[1]=-1;
		}
		if (fx.equals("W")){
			or[0]=-1;
			or[1]=0;
		}
		if (fx.equals("E")){
			or[0]=1;
			or[1]=0;
		}
		//判断是否lost,lost的话flag为1
		int flag=0;
		//开始执行指令，遇到转向则用当前方向向量乘以转向矩阵，遇到前进则当前坐标加上前进向量，加上的时候留意前进的坐标是否已经标记
		for(int i=0;i<instructions.length;i++){
			//System.out.printf("%c",instructions[i]);
			//判断指令，判断是否有效
			//左转
			if(instructions[i]=='L'){
				or=direction(or,L);
			}
			//右转
			if(instructions[i]=='R'){
				or=direction(or,R);
			}
			//前进
			if(instructions[i]=='F'){
				int tmpx=dr[0]+or[0];
				int tmpy=dr[1]+or[1];
				//前进后在边界内,不能忘记0，0的约束
				if (tmpx<=x-1 & tmpy<=y-1 & tmpx>=0 & tmpy>=0){
					dr[0]=tmpx;
					dr[1]=tmpy;
				}
				//前进后在边界外,当前点为边界点
				else{
					//如果边界上已有机器人lost，跳过这个指令
					if(location[dr[0]][dr[1]]==1){
						continue;
					}else{
					//如果边界上还没有机器人lost，当前机器人结束指令，lost,跳出循环
						location[dr[0]][dr[1]]=1;
						flag=1;
						break;
					}
				}
			}
		}
		//将方向坐标转变为方向
		String fxa="";
		if(or[0]==0 & or[1]==1){
			fxa="N";
		}
		if(or[0]==0 & or[1]==-1){
			fxa="S";
		}
		if(or[0]==1 & or[1]==0){
			fxa="E";
		}
		if(or[0]==-1 & or[1]==0){
			fxa="W";
		}
		//判断是否lost
		if (flag==1){
			System.out.printf("%d %d %s LOST\n", dr[0],dr[1],fxa);
		}else{
			System.out.printf("%d %d %s\n", dr[0],dr[1],fxa);			
		}
		return location;
	}

	/**
	 * direction:<br/>
	 * @param or
	 * @param r
	 * @return
	 */
	private static int[] direction(int[] or, int[][] r) {
		int[] tmp={0,0};
		tmp[0]=or[0]*r[0][0]+or[1]*r[1][0];
		tmp[1]=or[0]*r[0][1]+or[1]*r[1][1];
		return tmp;
	}

}
