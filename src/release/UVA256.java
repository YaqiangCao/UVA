package release;

import java.util.Scanner;

public class UVA256 {
	public static void main(String args[]) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N=cin.nextInt();
			QS(N);
		}
	}
	
	private static void QS(int n) {
		int minN=0;
		int maxN=0;
		String maxNs="";
		String tmp="";
		for(int i=0;i<n;i++){
			 maxNs+="9";
			 tmp+="0";
		}
		maxN=Integer.parseInt(maxNs);
		for(int i=minN;i<=maxN;i++){
			String tmp1="";
			String tmp2=String.valueOf(i);
			tmp1=tmp.substring(0,n-tmp2.length())+tmp2;
			//System.out.println(tmp1.substring(0,n/2));
			int a=Integer.parseInt(tmp1.substring(0,n/2));
			int b=Integer.parseInt(tmp1.substring(n/2));
			if ((a+b)*(a+b)==i){
				System.out.println(tmp1);
			}
		}
	}

}
