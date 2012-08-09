import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class UVA136 {
	public static int uglyJudge(int x){
		int judge=1;
		int k=2;
		while(k<=x){
			if(x%k==0){
				if(k!=2 && k!=3 && k!=5){
					judge=0;
					break;
				}
				x=x/k;
			}else{
				k++;
			}
		}
		return judge;
	}
	
	public static void main(String args[]){
		int count=5;
		int i=5;
		while(count<1500){
			i=i+1;
			int judge=uglyJudge(i);
			if(judge==1){
				count=count+1;
			}
		}
		System.out.println("The 1500'th ugly number is "+i+".");
		
	}
}
