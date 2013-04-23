package release;
//reference:http://www.cnblogs.com/devymex/archive/2010/08/14/1799713.html
import java.util.Scanner;
import java.util.TreeSet;

public class UVA106 {
	public static int gcd(int a,int b){
		return b==0? a:gcd(b,a%b);
	}
	
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N=cin.nextInt();
			int maxI=(int)Math.sqrt(N)+1;
			int[] result=new int[N];
			for(int i=0;i<result.length;i++){
				result[i]=0;
			}
			int count=0;
			for(int i=1;i<=maxI;i++){
				for(int j=i+1;j<=maxI;j=j+2){
					if(gcd(i,j)==1){
						int a=2*i*j;
						int b=j*j-i*i;
						int c=i*i+j*j;
						if(c>N){
							break;
						}else{
							result[a-1]=1;
							result[b-1]=1;
							result[c-1]=1;
							count+=1;
							for(int k=2;;k++){
								if(c*k>N){
									break;
								}else{
									result[a*k-1]=1;
									result[b*k-1]=1;
									result[c*k-1]=1;
								}
							}
						}
					}
				}
			}
			int noncont=0;
			for(int i=0;i<result.length;i++){
				if(result[i]==0){
					noncont+=1;
				}
			}
			System.out.printf("%d %d\n",count,noncont);
		}
		
	}
}
