package release;

import java.util.Scanner;

public class UVA104 {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			//读入兑换比例
			int N=cin.nextInt();
			if(N<2){
				continue;
			}
			double[][][] d=new double[N+1][N+1][N+1];
			int[][][] path=new int[N+1][N+1][N+1];
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					if (i!=j){
						d[i][j][1]=cin.nextDouble();
					}else{
						d[i][j][1]=(double) 1.00;
					}
					path[i][j][1]=i;
				}
			}
			//调用子函数查找序列
			findSeq(d,path,N);
		}
	}

	private static void findSeq(double[][][] d, int[][][] path, int n) {
		for(int k=2;k<=n;k++){
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					d[i][j][k]=(float) 0.0;
					for(int m=1;m<=n;m++){
						double t=d[i][m][k-1]*d[m][j][1];
						if(t>d[i][j][k]){
							d[i][j][k]=t;
							for (int q=2;q<k;q++){
								path[i][j][q]=path[i][m][q];
							}
							path[i][j][k]=m;
						}
					}
				}
			}
			for(int i=1;i<=n;i++){
				if(d[i][i][k]>=1.01){ 
					for(int j=1;j<=k;j++){
						System.out.printf("%d ", path[i][i][j]);
					}
					System.out.printf("%d\n", i);
					return;
				}
			}
		}
		System.out.printf("no arbitrage sequence exists\n");
	}

}
