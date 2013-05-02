/**
 * Project Name:UVA
 * File Name:UVA11512.java
 * Package Name:dev
 * Created Date:Apr 30, 20137:49:54 PM
 * Modified Date: Apr 30, 20137:49:54 PM
 * Copyright (c) 2013, caoyaqiang0410@gmail.com All Rights Reserved.
 */
package dev;

import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


class SuffixArray {
    final String[] suffixes;
    final int N;

    public SuffixArray(String s) {
        N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < N; i++)
            suffixes[i] = s.substring(i);
        Arrays.sort(suffixes);
    }

    // ith sorted suffix
    public String select(int i) { return suffixes[i]; }
    
    // length of longest common prefix of s and t
    public static int lcp(String s, String t) {
        int N = Math.min(s.length(), t.length());
        for (int i = 0; i < N; i++)
            if (s.charAt(i) != t.charAt(i)) return i;
        return N;
    }

    // longest common prefix of suffixes(i) and suffixes(i-1)
    public int lcp(int i) {
        return lcp(suffixes[i], suffixes[i-1]);
    }
}




public class UVA11107 {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int n=Integer.parseInt(cin.next());
			if(n==0){
				return;
			}else{
				int[] ls=new int[n+1];
				ls[0]=0;
				String line="";
				for(int i=1;i<=n;i++){
					String tmp=cin.next();
					line+=tmp+i;
					ls[i]=ls[i-1]+1+tmp.length();
				}
				findSub(line,n,ls);
			}
		}
	}

	private static void findSub(String line, int n, int[] ls) {
        SuffixArray suffix = new SuffixArray(line);
        //the length of repeat substring
        int mm=1;
        //the repeat substring
        ArrayList<String> rs=new ArrayList<String>(  );
        //find the longest common substring
        for(int i=1;i<suffix.N;i++){
            int h=suffix.lcp(i);
            if( h<mm ){
                continue;
            }
            String tmps=suffix.select( i ).substring( 0,h );
            //the repeat time of the tmp substring
            int tmpr=0;
            int j=0;
            //find the repeat time
            while( true ){
               	j=line.indexOf(tmps,j);
               	if(j==-1){
               		break;
               	}
               	tmpr+=1;
               	//change the start index for substring search to next line
               	for(int k=1;k<ls.length;k++){
               		if(j<ls[k]){
               			j=ls[k];
               			break;
               		}
               	}
               	if(j>=line.length()){
               		break;
               	}
            }
            if( tmpr<=n/2 ){
                continue;
            }
            if( h>mm ){
                rs.clear(  );
            }
            rs.add( tmps );
            mm=h;
        }
        if( rs.size()==0 ){
            System.out.printf( "?\n\n");    
        }else{
        	for(String r:rs){
        		System.out.printf( "%s\n",r);
        	}
        	System.out.printf( "\n");
        }
    }

}




