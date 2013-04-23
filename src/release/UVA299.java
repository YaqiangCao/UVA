package release;

import java.util.Scanner;

public class UVA299 {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int N=cin.nextInt();
		while(N>0){
			int L=cin.nextInt();
			int[] data=new int[L];
			for(int i=0;i<L;i++){
				data[i]=cin.nextInt();
			}
			int count=0;
			for(int i=0;i<L-1;i++){
				for(int j=i+1;j<L;j++){
					if(data[i]>data[j]){
						int tmp=data[i];
						data[i]=data[j];
						data[j]=tmp;
						count++;
					}
				}
			}
			System.out.printf("Optimal train swapping takes %d swaps.\n", count);
			N=N-1;
		}
	}

}
