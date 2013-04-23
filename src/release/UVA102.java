package release;

import java.util.*;
public class UVA102 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int b1=cin.nextInt(),g1=cin.nextInt(),c1=cin.nextInt(),b2=cin.nextInt(),g2=cin.nextInt(),c2=cin.nextInt(),b3=cin.nextInt(),g3=cin.nextInt(),c3=cin.nextInt();
			String[] str={"BCG","BGC","CBG","CGB","GBC","GCB"};
			int sum1=g1+c1+b2+g2+b3+c3;
			int sum2=g1+c1+b2+c2+b3+g3;
			int sum3=b1+g1+g2+c2+b3+c3;
			int sum4=b1+g1+b2+c2+g3+c3;
			int sum5=b1+c1+g2+c2+b3+g3;
			int sum6=b1+c1+b2+g2+g3+c3;
			int[] sum={sum1,sum2,sum3,sum4,sum5,sum6};
			int min=sum[0];
			int index=0;
			for(int i=0;i<6;i++){
				if(sum[i]<min){
					index=i;
					min=sum[i];
				}
			}
			System.out.println(str[index]+" "+min);
		}
	}
}
