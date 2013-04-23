package release;
//reference:http://www.knightzone.org/wordpress/archives/1140
import java.util.Scanner;

public class UVA108 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N=cin.nextInt();
			int[][] data=new int[N+1][N+1];
			//read the matrix in
			for(int i=0;i<=N;i++){
				for(int j=0;j<=N;j++){
					if(i==0 || j==0){
						data[i][j]=0;
					}else{
						data[i][j]=cin.nextInt();
					}
				}
			}
			//caculate the column sum
			int[][] colSum=new int[N+1][N+1];
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					colSum[i][j]=colSum[i-1][j]+data[i][j];
				}
			}
			int maxSum=Integer.MIN_VALUE;
			for(int i=1;i<=N;i++){
				for(int j=i;j<=N;j++){
					int sum=0;
					for(int k=1;k<=N;k++){
						sum+=colSum[j][k]-colSum[i-1][k];
						if(sum>maxSum){
							maxSum=sum;
						}
						if(sum<0){
							sum=0;
						}
					}
				}
			}
			System.out.println(maxSum);
		}
	}
}
