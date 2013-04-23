/**
 * Project Name:UVA
 * File Name:UVA118.java
 * Package Name:dev
 * Created Date:2012-12-29����10:28:36
 * Modified Date: 2012-12-29����10:28:36
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.Scanner;

/**
 * ClassName:UVA118 <br/>
 * date: 2012-12-29����10:28:36 <br/>
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
		//�������Ͻ����꣬�ǻ������ж��ı߽��
		int x=cin.nextInt()+1,y=cin.nextInt()+1;
		//��Ǹ����㣬����л����������ﳬ���߽磬��Ϊ1������Ϊ0
		int location[][]=new int[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				location[i][j]=0;
			}
		}
		//��������������Լ����ǵ�ָ�ִ��
		while(cin.hasNext()){
			//�����˵�����ͳ�ʼ����
			int drx=cin.nextInt();
			int dry=cin.nextInt();
			String fx=cin.next().trim().toUpperCase();
			int[] dr={drx,dry};
			//ָ��
			char[] instructions=cin.next().trim().toUpperCase().toCharArray();
			//ִ��ָ��ͱ������
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
		//ת�����,L������ת��R������ת
		int[][] L={{0,1},{-1,0}};
		int[][] R={{0,-1,},{1,0}};
		//�����˶�̬ǰ������,��������һ�θ�����������ֵ
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
		//�ж��Ƿ�lost,lost�Ļ�flagΪ1
		int flag=0;
		//��ʼִ��ָ�����ת�����õ�ǰ������������ת���������ǰ����ǰ�������ǰ�����������ϵ�ʱ������ǰ���������Ƿ��Ѿ����
		for(int i=0;i<instructions.length;i++){
			//System.out.printf("%c",instructions[i]);
			//�ж�ָ��ж��Ƿ���Ч
			//��ת
			if(instructions[i]=='L'){
				or=direction(or,L);
			}
			//��ת
			if(instructions[i]=='R'){
				or=direction(or,R);
			}
			//ǰ��
			if(instructions[i]=='F'){
				int tmpx=dr[0]+or[0];
				int tmpy=dr[1]+or[1];
				//ǰ�����ڱ߽���,��������0��0��Լ��
				if (tmpx<=x-1 & tmpy<=y-1 & tmpx>=0 & tmpy>=0){
					dr[0]=tmpx;
					dr[1]=tmpy;
				}
				//ǰ�����ڱ߽���,��ǰ��Ϊ�߽��
				else{
					//����߽������л�����lost���������ָ��
					if(location[dr[0]][dr[1]]==1){
						continue;
					}else{
					//����߽��ϻ�û�л�����lost����ǰ�����˽���ָ�lost,����ѭ��
						location[dr[0]][dr[1]]=1;
						flag=1;
						break;
					}
				}
			}
		}
		//����������ת��Ϊ����
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
		//�ж��Ƿ�lost
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
