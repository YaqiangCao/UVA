package release;
import java.util.*;
public class UVA151 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N=cin.nextInt();
			if(N==0){
				return;
			}
			for(int m=1;m<=N;m++){
				ArrayList n=new ArrayList();
				for(int i=0;i<N;i++){
					n.add(i, i+1);
				}
				int i=0;
				while(n.size()>1){
					n.remove(i);
					i=(i+m-1)%n.size();
				}
				if((Integer)n.get(0)==13){
					System.out.println(m);
					break;
				}else{
					continue;
				}
			}
		}
	}
}