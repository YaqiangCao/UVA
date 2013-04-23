package release;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Mycomparator implements Comparator{
	public int compare(Object o1,Object o2) {
        int p1=(Integer)o1;
        int p2=(Integer)o2;  
       if(p1<p2)
           return 1;
       else
           return 0;
       }
}

public class UVA120 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String[] line=cin.nextLine().split(" ");
			ArrayList a=new ArrayList();
			ArrayList b=new ArrayList();
			ArrayList filp=new ArrayList();
			ArrayList c=new ArrayList();
			for(int i=0;i<line.length;i++){
				a.add(Integer.parseInt(line[i]));
				b.add(Integer.parseInt(line[i]));
				c.add(Integer.parseInt(line[i]));
			}
			Comparator comp = new Mycomparator();
			Collections.sort(b,comp);
			Collections.reverse(a);
			for(int i=0;i<b.size();i++){
				int sortIndex=a.indexOf(b.get(i));
				if(sortIndex<i){
					for(int j=i;j<a.size();j++){
						if(a.get(j).equals(b.get(i))){
							sortIndex=j;
							break;
						}
					}
				}
				if(sortIndex==i){
					continue;
				}else{
					List filpedSub=new ArrayList(); 
					if(sortIndex!=a.size()-1){
						filp.add(sortIndex+1);
						filpedSub=a.subList(sortIndex, a.size());
						Collections.reverse(filpedSub);
						for(int j=0;j<filpedSub.size();j++){
							a.set(sortIndex+j, filpedSub.get(j));
						}
					}
					filp.add(i+1);
					filpedSub=a.subList(i, a.size());
					Collections.reverse(filpedSub);
					for(int j=0;j<filpedSub.size();j++){
						a.set(i+j, filpedSub.get(j));
					}
				}
			}
			for(int i=0;i<c.size();i++){
				System.out.printf("%d ",c.get(i));
			}
			System.out.printf("\n");
			for(int i=0;i<filp.size();i++){
				System.out.printf("%d ",filp.get(i));
			}
			System.out.printf("0\n");
		}
	}
}
