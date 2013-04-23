package release;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class UVA119 {
	public static void main(String[] args)  throws Exception{
		Scanner cin=new Scanner(System.in);
		int head=1;
		while(cin.hasNext()){
			int N=Integer.parseInt(cin.nextLine().trim().toString());
			String[] people =new String[N];
			people=cin.nextLine().split(" ");
			Hashtable people2gift=new Hashtable();
			for(int i=0;i<N;i++){
				String[] line=cin.nextLine().split(" ");
				Hashtable giftdetails=new Hashtable();
				giftdetails.put("money", Integer.parseInt(line[1]));
				giftdetails.put("number", Integer.parseInt(line[2]));
				ArrayList newline=new ArrayList();
				if(line.length>3){
					for(int j=3;j<line.length;j++){
						newline.add(line[j]);
					}
				}
				giftdetails.put("friends", newline);
				if((Integer)giftdetails.get("number")>0){
					giftdetails.put("allout",((Integer)giftdetails.get("money")/(Integer)giftdetails.get("number"))*(Integer)giftdetails.get("number"));
					giftdetails.put("evenout",(Integer)giftdetails.get("allout")/(Integer)giftdetails.get("number"));
				}else{
					giftdetails.put("allout",0);
					giftdetails.put("evenout",0);
				}
				
				giftdetails.put("gain",-(Integer)giftdetails.get("allout"));
				people2gift.put(line[0], giftdetails);
			}
//			System.out.println(people2gift);
			for(int i=0;i<people.length;i++){
				for(int j=0;j<people.length;j++){
					if(i!=j){
						String p1=people[i];
						String p2=people[j];
						Hashtable giftdetailsp1=(Hashtable) people2gift.get(p1);
						Hashtable giftdetailsp2=(Hashtable) people2gift.get(p2);
						if((Integer)giftdetailsp2.get("number")==0){
							continue;
						}
						else{
							ArrayList ps=(ArrayList)giftdetailsp2.get("friends");
							if(ps.contains(p1)){
								giftdetailsp1.put("gain", (Integer)giftdetailsp1.get("gain")+(Integer)giftdetailsp2.get("evenout"));
							}
							people2gift.put(p1, giftdetailsp1);
						}
					}
				}
			}
			if(head==1){
				head=0;
			}else{
				System.out.printf("\n");
			}
			for(int i=0;i<people.length;i++){
				String p=people[i];
				Hashtable giftdetails=(Hashtable) people2gift.get(p);
				System.out.printf("%s %d\n",p,giftdetails.get("gain"));
			}
		}
	}
}

