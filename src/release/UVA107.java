package release;
import java.util.Scanner;

public class UVA107 {
	public static int powInt(int a,int b){
		int result=1;
		for(int i=0;i<b;i++)
			result=result*a;
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int H=cin.nextInt(),wc=cin.nextInt();
			if(H==0 && wc==0){
				return;
			}else{
				if(H==1 && wc==1){
					System.out.printf("%d %d\n",0,1);
					continue;
				}else{
					int kH=0,kwc=0;
					int k=0;
					for(k=1;;k++){
						double k2=(double)1.0/k;
						float kHt=(float)Math.pow((double)H, k2);
						float kwct=(float)Math.pow((double)wc, k2);
						if(k==2){
						}
						if((kHt-kwct)==(float)1){
							kH=(int)kHt;
							kwc=(int)kwct;
							break;
						}
					}
					int N=kwc;
					int nwc=0;
					int nT=0;
					for(int i=0;i<k;i++){
						nwc+=powInt(N,i);
						nT+=H*powInt(N,i);
						H=H/(N+1);
					}
					nT+=powInt(N,k);
					System.out.printf("%d %d\n",nwc,nT);	
				}
			}
		}
	}
}
