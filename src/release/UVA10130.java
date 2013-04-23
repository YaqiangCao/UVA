package release;

import java.util.Scanner;

public class UVA10130 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		int T=cin.nextInt();
		for(int i=T;i>0;i--){
			int N=cin.nextInt();
			int[] p=new int[N];
			int[] w=new int[N];
			int[] f=new int[32];
			for(int j=0;j<N;j++){
				p[j]=cin.nextInt();
				w[j]=cin.nextInt();
			}
			for(int j=0;j<32;j++){
				f[j]=0;
			}
			for(int m=0;m<N;m++){
				for(int n=30;n>=1;n--){
					if((n>=w[m]) && (f[n-w[m]]+p[m]>f[n])){
						f[n]=f[n-w[m]]+p[m];
					}
				}
			}
			int G=cin.nextInt();
			int ans=0;
			for(int k=G;k>0;k--){
				ans+=f[cin.nextInt()];
			}
			System.out.println(ans);
		}
	}
}
