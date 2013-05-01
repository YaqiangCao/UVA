/**
 * Project Name:UVA
 * File Name:UVA11512.java
 * Package Name:dev
 * Created Date:Apr 30, 20137:49:54 PM
 * Modified Date: Apr 30, 20137:49:54 PM
 * Copyright (c) 2013, caoyaqiang0410@gmail.com All Rights Reserved.
 */
package release;

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
    

    // size of string
    public int length() { return N; }

    // index of ith sorted suffix
    public int index(int i) { return N - suffixes[i].length(); }

    // ith sorted suffix
    public String select(int i) { return suffixes[i]; }

    // number of suffixes strictly less than query
    public int rank(String query) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = query.compareTo(suffixes[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    } 

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

    // longest common prefix of suffixes(i) and suffixes(j)
    public int lcp(int i, int j) {
        return lcp(suffixes[i], suffixes[j]);
    }

}

public class UVA11512 {
	public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N=cin.nextInt();
			if(N==0){
				return;
			}
			for(int i=1;i<=N;i++){
				String line=cin.next().trim(  );
                findSub( line );
			}
		}
	}

	private static void findSub(String line) {
        SuffixArray suffix = new SuffixArray(line);
        //the length of repeat substring
        int mm=1;
        //the repeat time of the substring,only output the repeate time >=2
        int r=0;
        //the repeat string
        String ss="";
        for(int i=1;i<suffix.N;i++){
            int lcp=suffix.lcp( i );
            if( lcp<mm ){
                continue;
            }
            String tmps=suffix.select( i ).substring( 0,lcp );
            //the repeat time of the tmp substring
            int tmpr=0;
            int j=0;
            //find the repeat time
            while( line.indexOf(tmps,j) !=-1 ){
            	tmpr+=1;
            	j=line.indexOf(tmps,j)+1;
            }
            if( tmps.length(  )==mm ){
                if( tmpr>r ) {
                    r=tmpr;
                    ss=tmps;
                }
            }else{
                mm=tmps.length(  );
                ss=tmps;
                r=tmpr;
            }
        }
        if( r<2 ){
            System.out.println( "No repetitions found!");    
        }else{
            ss+=" "+r;
            System.out.println( ss );
        }
	}
    
}
