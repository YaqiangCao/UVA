/**
 * Project Name:1.UVA
 * File Name:UVA167.java
 * Package Name:dev
 * Created Date:Jan 16, 201310:15:16 PM
 * Modified Date: Jan 16, 201310:15:16 PM
 * Copyright (c) 2013, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * ClassName:UVA167 <br/>
 * date: Jan 16, 201310:15:16 PM <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA167 {

    //八皇后问题:http://blog.csdn.net/chenglinhust/article/details/8248514
    public static void main(String[] args) {
        //首先计算出八个皇后的坐标
        ArrayList<ArrayList> eightQuenesLocation=new ArrayList();
        eightQuenesLocation=getEightQuenesLocation();
        //System.out.println(eightQuenesLocation);
        Scanner cin=new Scanner(System.in);
        //读入需要计算的棋盘数
        int N=cin.nextInt();
        int board[][]=new int[8][8];
        while(N>0){
            //依次读入每个棋盘进行处理
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    board[i][j]=cin.nextInt();
                }
            }
            //得到这一棋盘的最大得分
            getScore(board,eightQuenesLocation);
            //计数
            N=N-1;
        }
    }

	/**
	 * getScore:<br/>
	 * @param board
	 * @param eightQuenesLocation
	 */
	public static void getScore(int[][] board, ArrayList<ArrayList> eightQuenesLocation) {
        int maxScore=0;
        for(int i=0;i<eightQuenesLocation.size();i++){
           int score=0;
           ArrayList<Integer> queneLocation=eightQuenesLocation.get(i);
           for(int j=0;j<queneLocation.size();j++){
                score+=board[j][(Integer) queneLocation.get( j )];
           }
           if (i==0){
            maxScore=score;
            }else{
                if(score>maxScore){
                    maxScore=score;
                }
            }
        }
        System.out.printf("%5d\n",maxScore);
	}


	/**
	 * getEightQuenesLocation:<br/>
	 * @return
	 */
	public static ArrayList getEightQuenesLocation() {
        //用来存储所有的坐标
        ArrayList eightQuenesLocation=new ArrayList();
        //ColumnIndex,数组中第i个数字表示位于第i行的皇后的列号
        ArrayList<Integer> ColumnIndex=new ArrayList();
        //对ColumnIndex初始化为0到7
        for(int i=0;i<8;i++){
            ColumnIndex.add(i);
        }
        
        //ColumnIndex全排列并检查八皇后规则
        while(true){
           //全排列已经结束，跳出循环
           if (ColumnIndex.isEmpty()){
                break;
           }else{
               //检查是否满足八皇后规则，
               //满足的话加入坐标集合
               if (checkQuene(ColumnIndex)){
            	   	//注意这里的深拷贝和浅拷贝的问题
                    eightQuenesLocation.add( ColumnIndex.clone() );
               }
               //全排列下一个
               ColumnIndex=nextQuene( ColumnIndex );
           }
        }
        //System.out.println(eightQuenesLocation);
        return eightQuenesLocation;
	}

	/**
	 * checkQuene:检查皇后们是否在一个对角线上
	 * @param ColumnIndex
	 * @return
	 */
	public static boolean checkQuene(ArrayList<Integer> ColumnIndex) {
		boolean flag=true;
	    for(int i=0;i<ColumnIndex.size()-1;i++){
            for(int j=i+1;j<ColumnIndex.size();j++){
                if (i-j==ColumnIndex.get(i)-ColumnIndex.get(j) | i-j==ColumnIndex.get(j)-ColumnIndex.get(i) ){
                	flag=false;
                	break;
                }
            }
        }
        return flag;
    }

	/**
	 * nextQuene:<br/>
	 * @param ColumnIndex
	 * @return
	 */
	public static ArrayList<Integer> nextQuene(ArrayList<Integer> ColumnIndex) {
		int flag=0;
	    int i=ColumnIndex.size()-1;
        //检查是否是最后一个坐标，不存在下一个全排列
	    for(;i>=1;i--){
		    if(ColumnIndex.get(i-1)<ColumnIndex.get(i)){
			    flag=1;
			    break;
	    	}
    	}
	    if(flag==0){
		    ColumnIndex.clear();
	    }else{
		    int k=i-1;
		    for(int j=ColumnIndex.size()-1;j>k;j--){
			    if(ColumnIndex.get(j)>ColumnIndex.get(k)){
				    Collections.swap(ColumnIndex, k, j);
				    Collections.sort(ColumnIndex.subList(k+1, ColumnIndex.size()));
				    break;
		    	}
	    	}
    	}
	    return ColumnIndex;
	}

}
