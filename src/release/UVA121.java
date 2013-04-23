package release;
//reference:http://www.cnblogs.com/devymex/archive/2010/08/15/1799966.html
import java.util.Scanner;

public class UVA121 {
	public static int Skew(float x, float y){
		float fSqrt3_2=0.8660254f;
		int nRows=0;
		if(y>=1){
			nRows+=1;
		}
		nRows+=(int)((y-1)/fSqrt3_2);
		if(x-(int)x<0.5f){
			return nRows*(int)x-nRows/2;
		}else{
			return nRows*(int)x;
		}
	}
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			float x=cin.nextFloat(),y=cin.nextFloat();
			int nGrid=(int)x * (int)y;
			int nSkew=Math.max(Skew(x,y),Skew(y,x));
			if(nGrid>=nSkew){
				System.out.printf("%d grid\n",nGrid);
			}else{
				System.out.printf("%d skew\n",nSkew);
			}
		}

	}

}
