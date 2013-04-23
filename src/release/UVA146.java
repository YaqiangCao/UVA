package release;

import java.util.*;
public class UVA146 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String line=cin.nextLine().toLowerCase();
			if(line.equals("#")){
				return;
			}else{
				char[] cs=line.toCharArray();
				int flag=0;
				for(int i=0;i<cs.length-1;i++){
					for(int j=i+1;j<cs.length;j++){
						if(cs[i]<cs[j]){
							flag=1;
						}
					}
				}
				if(flag==0){
					System.out.println("No Successor");
					continue;
				}
				else{
					int start = 0;
					int end=0;
					for(int i=cs.length-1;i>0;i--){
						int flag2=1;
						for(int j=i-1;j>-1;j--){
							if(cs[j]<cs[i]){
								start=j;
								end=i;
								flag2=0;
								break;
							}
						}
						if(flag2==0){
							break;
						}	
					}
					char tmp=cs[end];
					cs[end]=cs[start];
					cs[start]=tmp;
					for(int i=start+1;i<cs.length-1;i++){
						for(int j=i+1;j<cs.length;j++){
							if(cs[i]>cs[j]){
								char tmp2=cs[j];
								cs[j]=cs[i];
								cs[i]=tmp2;
							}
						}
					}
					System.out.println(cs);
				}
				
			}
		}
	}
}
