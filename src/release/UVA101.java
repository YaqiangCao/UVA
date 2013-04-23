/**
 * Project Name:UVA
 * File Name:UVA101.java
 * Package Name:dev
 * Created Date:2012-8-26ÏÂÎç5:40:39
 * Modified Date: 2012-8-26ÏÂÎç5:40:39
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName:UVA101 <br/>
 * date: 2012-8-26ÏÂÎç5:40:39 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA101 {
	/**
	 * main:<br/>
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=bf.readLine())!=null){
			int N=Integer.parseInt(line.trim());
			ArrayList<ArrayList> blocks=new ArrayList();
			for(int i=0;i<N;i++){
				ArrayList block=new ArrayList();
				block.add(i);
				blocks.add(block);
			}
			line=bf.readLine().trim();
			while(!line.equals("quit")){
				String[] command=line.split(" ");
				//Here are the Gotchas of the problem, if a==b or a and b in the same stack, the command is invalid, continue this command
				int a=Integer.parseInt(command[1]);
				int b=Integer.parseInt(command[3]);
				int m=0,n=0;
				for(int i=0;i<blocks.size();i++){
					ArrayList block=(ArrayList) blocks.get(i);
					if (block.contains(a)){
						m=i;
					}
					if(block.contains(b)){
						n=i;
					}
				}
				if(a!=b && m!=n){
					if(command[0].equals("move")){
						if(command[2].equals("onto")){
							blocks=moveOnto(blocks,a,m,b,n);
						}else{
							blocks=moveOver(blocks,a,m,b,n);
						}
					}
					if(command[0].equals("pile")){
						if(command[2].equals("onto")){
							blocks=pileOnto(blocks,a,m,b,n);
						}else{
							blocks=pileOver(blocks,a,m,b,n);
						}
					}
				}
				line=bf.readLine();
				//just used for debug
				//System.out.println(line);
				//printBlocks(blocks);
			}
			printBlocks(blocks);
		}
	
	}

	/**
	 * pileOver:<br/>
	 * @param blocks
	 * @param a
	 * @param m
	 * @param b
	 * @param n
	 * @return
	 */
	private static ArrayList<ArrayList> pileOver(ArrayList<ArrayList> blocks,int a, int m, int b, int n) {
		//just used for debug
		//System.out.println("a:"+a+" b:"+b+" m:"+m+" n:"+n);
		// TODO do the command of pile a over b
		ArrayList blocka=(ArrayList) blocks.get(m);
		ArrayList blockb=(ArrayList) blocks.get(n);
		int k=blocka.indexOf(a);
		for(int i=k;i<blocka.size();i++){
			blockb.add(blocka.get(i));
		}
		if(k==0){
			blocks.set(m, new ArrayList());
		}else{
			ArrayList subblocka=new ArrayList();
			for(int i=0;i<k;i++){
				subblocka.add(blocka.get(i));
			}
			blocks.set(m,subblocka);
		}
		blocks.set(n, blockb);
		return blocks;
	}

	/**
	 * pileOnto:<br/>
	 * @param blocks
	 * @param a
	 * @param m
	 * @param b
	 * @param n
	 * @return
	 */
	private static ArrayList<ArrayList> pileOnto(ArrayList<ArrayList> blocks,int a, int m, int b, int n) {
		// TODO do the command pile a onto b
		ArrayList blocka=(ArrayList) blocks.get(m);
		ArrayList blockb=(ArrayList) blocks.get(n);
		int k=blockb.indexOf(b);
		for(int i=k+1;i<blockb.size();i++){
			int tmpb=(Integer) blockb.get(i);
			ArrayList tmpblock=(ArrayList) blocks.get(tmpb);
			tmpblock.add(tmpb);
			blocks.set(tmpb, tmpblock);
		}
		ArrayList subblockb=new ArrayList();
		for(int i=0;i<=k;i++){
			subblockb.add(blockb.get(i));
		}
		blockb=subblockb;
		int q=blocka.indexOf(a);
		for(int i=q;i<blocka.size();i++){
			blockb.add(blocka.get(i));
		}
		if(q==0){
			blocks.set(m, new ArrayList());
		}else{
			//caution:if blocka.subList(0,q+1) is null, it'll return null
			ArrayList subblocka=new ArrayList();
			for(int i=0;i<q;i++){
				subblocka.add(blocka.get(i));
			}
			blocks.set(m,subblocka);
		}
		blocks.set(n, blockb);
		return blocks;
	}

	/**
	 * moveOver:<br/>
	 * @param blocks
	 * @param a
	 * @param m
	 * @param b
	 * @param n
	 * @return
	 */
	private static ArrayList<ArrayList> moveOver(ArrayList<ArrayList> blocks,int a, int m, int b, int n) {
		// TODO do the command move a over b
		ArrayList blocka=(ArrayList) blocks.get(m);
		ArrayList blockb=(ArrayList) blocks.get(n);
		int k=blocka.indexOf(a);
		for(int i=k+1;i<blocka.size();i++){
			int tmpa=(Integer) blocka.get(i);
			ArrayList tmpblock=(ArrayList) blocks.get(tmpa);
			tmpblock.add(tmpa);
			blocks.set(tmpa, tmpblock);
		}
		blockb.add(a);
		if(k==0){
			blocks.set(m, new ArrayList());
		}else{
			ArrayList subblocka=new ArrayList();
			for(int i=0;i<k;i++){
				subblocka.add(blocka.get(i));
			}
			blocks.set(m,subblocka);
		}
		blocks.set(n, blockb);
		return blocks;
	}

	/**
	 * moveOnto:<br/>
	 * @param blocks
	 * @param a: the a in the problem
	 * @param m: the index of the blocks that a in 
	 * @param b: the b in the problem
	 * @param n: the index of the blocks that b in
	 * @return the command excuted blocks
	 */
	private static ArrayList<ArrayList> moveOnto(ArrayList<ArrayList> blocks,int a, int m, int b, int n) {
		ArrayList blocka=(ArrayList) blocks.get(m);
		ArrayList blockb=(ArrayList) blocks.get(n);
		int k=blockb.indexOf(b);
		for(int i=k+1;i<blockb.size();i++){
			int tmpb=(Integer) blockb.get(i);
			ArrayList tmpblock=(ArrayList) blocks.get(tmpb);
			tmpblock.add(tmpb);
			blocks.set(tmpb, tmpblock);
		}
		ArrayList subblockb=new ArrayList();
		for(int i=0;i<=k;i++){
			subblockb.add(blockb.get(i));
		}
		blockb=subblockb;
		int q=blocka.indexOf(a);
		for(int i=q+1;i<blocka.size();i++){
			int tmpa=(Integer) blocka.get(i);
			ArrayList tmpblock=(ArrayList) blocks.get(tmpa);
			tmpblock.add(tmpa);
			blocks.set(tmpa, tmpblock);
		}
		subblockb.add(a);
		if(q==0){
			blocks.set(m, new ArrayList());
		}else{
			//caution:if blocka.subList(0,q+1) is null, it'll return null
			ArrayList subblocka=new ArrayList();
			for(int i=0;i<q;i++){
				subblocka.add(blocka.get(i));
			}
			blocks.set(m,subblocka);
		}
		blocks.set(n, blockb);
		return blocks;
	}

	/**
	 * printBlocks:<br/>
	 * @param blocks
	 */
	private static void printBlocks(ArrayList<ArrayList> blocks) {
		// TODO do the print according to the required format
		for(int i=0;i<blocks.size();i++){
			String result=i+":";
			ArrayList block=(ArrayList) blocks.get(i);
			for(int j=0;j<block.size();j++){
				result+=" "+block.get(j);
			}
			System.out.printf("%s\n",result);
		}
	}

}
