/**
 * Project Name:UVA
 * File Name:UVA11512.java
 * Package Name:dev
 * Created Date:Apr 30, 20137:49:54 PM
 * Modified Date: Apr 30, 20137:49:54 PM
 * Copyright (c) 2013, caoyaqiang0410@gmail.com All Rights Reserved.
 * 主要参考资料:后缀数组——处理字符串的有力工具
 */
package dev;

import java.util.Scanner;
import java.util.Arrays;


class SuffixArray {
    final String[] suffixes;
    final int[] height;
    final int N;

    public SuffixArray(String s) {
        N = s.length();
        suffixes = new String[N];
        height=new int[N];
        for (int i = 0; i < N; i++)
            suffixes[i] = s.substring(i);
        Arrays.sort(suffixes);
        for( int i=1;i<N;i++ ){
           height[ i ] =lcp( i );
        }
    }

    // ith sorted suffix
    public String select(int i) { return suffixes[i]; }
    
   // length of longest common prefix of s and t
    private static int lcp(String s, String t) {
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
			}
			String line="";
			for(int i=1;i<=n;i++){
                line+=cin.next()+i;
			}
			System.out.println(line);
			findSub(line,n);
		}
	}

	private static void findSub(String line, int n) {
        SuffixArray suffix = new SuffixArray(line);
        //the length of repeat substring
        int mm=1;
        //the repeat time of the substring,only output the repeate time >=2
        int r=0;
        //the repeat string/strings
        String ss="";
        //find the longest common substring
        for(int i=1;i<suffix.N;i++){
            int h=suffix.height[ i ];
            if( h>mm ){
                mm=h;
            }
        }
        //for every longest common substring, check their repeat time
        for(int i=1;i<suffix.N;i++){
            int h=suffix.height[ i ];
            if( h==mm ){
                String tmps=suffix.select( i ).substring( 0,h );
              //the repeat time of the tmp substring
                int tmpr=0;
                int j=0;
                //find the repeat time
                while( line.indexOf(tmps,j) !=-1 ){
                	tmpr+=1;
                	j=line.indexOf(tmps,j)+tmps.length(  );
                	if (j>=line.length()){
                		break;
                	}
                }
                if( tmpr>n/2 ){
                   ss+=tmps+"\n";
                }
            }
            
        }
        if( ss.length(  )==0 ){
            System.out.printf( "?\n\n");    
        }else{
            System.out.printf( "%s\n",ss );
        }
    }

}




