package release;
import java.util.ArrayList;
import java.util.Scanner;
public class UVA188 {
	//求整数指�?	
	private static int pow(int x,int y){
		int z=1;
		for(int i=1;i<=y;i++)
		{
			z=z*x;
		}
		return z;
	}
	//求比较小的整数�?
	private static int min(int x,int y){
		if(x<=y){
			return x;
		}else{
			return y;
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String line=cin.nextLine();
			String[] line2=line.split(" ");
			//愿题中有说是可能由一到多个空格隔�?���?��切去这些空格
			ArrayList<String> lineList=new ArrayList();
			for(int i=0;i<line2.length;i++){
				if(line2[i].trim().length()!=0){
					lineList.add(line2[i]);
				}
			}
			//得到table的大小n
			int n=lineList.size();
			//得到W
			int[] w=new int[n];
			for(int i=0;i<n;i++){
				int wi=0;
				for(int j=0;j<lineList.get(i).length();j++){
					wi=wi+(lineList.get(i).charAt(j)-'a'+1)*pow(32, (lineList.get(i).length()-j-1));
				}
				w[i]=wi;
			}
			//排序，得到C的最小�?
			for(int i=0;i<w.length-1;i++){
				for(int j=i+1;j<w.length;j++){
					if(w[i]>w[j]){
						int tmp=w[j];
						w[j]=w[i];
						w[i]=tmp;
					}
				}
			}
			//�?��按照规则搜索C
			int C=w[0];
			int i=0,j=1;
			//搜索停止条件是搜索到了最�?			
			while(i<=n-2){
				j=i+1;
				int flag=1;
				while(j<=n-1){
					if((C/w[i])%n==(C/w[j])%n){
						C=min((C/w[i]+1)*w[i],(C/w[j]+1)*w[j]);
						flag=0;
						break;
					}else{
						j=j+1;
					}
				}
				if(flag==1){
					i=i+1;
				}else{
					i=0;
				}
			}
			System.out.println(line);
			System.out.println(C);
			System.out.println();
		}
	}
}
