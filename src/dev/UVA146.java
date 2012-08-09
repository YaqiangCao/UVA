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
				//如果整个字符串，字符是从大到小排序，则没有successor
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
					for(int i=cs.length-1;i>0;i--){
						for(int j=i-1;j>-1;j--){
							if(cs[j]<=cs[i]){
								start=j;
								break;
							}
						}
					}
					char min=cs[start+1];
					int end=start+1;
					for(int i=start+1;i<cs.length;i++){
						if(cs[i]<min){
							min=cs[i];
							end=i;
						}
					}
					cs[end]=cs[start];
					cs[start]=min;
					for(int i=start+1;i<cs.length-1;i++){
						for(int j=start+2;j<cs.length;j++){
							if(cs[i]>cs[j]){
								char tmp=cs[j];
								cs[j]=cs[i];
								cs[i]=tmp;
							}
						}
					}
					System.out.println(cs);
				}
				
			}
		}
	}
}
