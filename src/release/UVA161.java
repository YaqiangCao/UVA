package release;

import java.util.*;

public class UVA161 {
	public static void printOut(int n){
		int hour=n/3600;
		int min=(n-hour*3600)/60;
		int sec=n-hour*3600-min*60;
		String result="0"+hour+":";
		if(min<10){
			result+="0"+min+":";
		}else{
			result+=min+":";
		}
		if(sec<10){
			result+="0"+sec;
		}else{
			result+=sec;
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		ArrayList<Integer> scenarios=new ArrayList();
		int count=0;
		while(cin.hasNextInt()){
			int a=cin.nextInt();
			if(a!=0){
				scenarios.add(a);
			}else{
				if(scenarios.size()==0){
					count++;
				}
				if(count==3){
					return;
				}
				if(scenarios.size()>0){
					int countS=0;
					for(int i=2*Collections.min(scenarios);i<=5*60*60+1;i++){
						int flag=1;
						for(int j=0;j<scenarios.size();j++){
							if(i%(scenarios.get(j)*2)>=(scenarios.get(j)-5)){
								flag=0;
								break;
							}else{
								countS++;
//								System.out.printf("time: %d counter: %d scenarios: %d\n",i,i%(scenarios.get(j)*2),scenarios.get(j));
							}
						}
						if(i==5*60*60+1){
							System.out.println("Signals fail to synchronise in 5 hours");
							break;
						}
						if(flag==0){
							continue;
						}
						if(flag==1 && countS>0){
							printOut(i);
							break;
						}
					}
					scenarios.clear();
				}
			}
		}

	}
}
