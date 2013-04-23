package release;

import java.util.*;
public class UVA100 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int start=cin.nextInt(),end=cin.nextInt();
			int start1=start,end1=end;
			if(start1>end1){
				int tmp=end1;
				end1=start1;
				start1=tmp;
			}
			Hashtable<Integer, Integer> result=new Hashtable();
			int max=0;
			for(int m=start1;m<end1+1;m++){
				int cycle=0;
				int n=m;
				while(true){
					if(n==1){
						cycle=cycle+1;
						result.put(m, cycle);
						break;
					}else{
						if(n%2==1){
							n=3*n+1;
						}else{
							n=n/2;
						}
						cycle=cycle+1;
					}
				}
				if(cycle>max){
					max=cycle;
				}
			}
			System.out.println(start+" "+end+" "+max);
		}
	}
}
