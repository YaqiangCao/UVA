package release;
import java.util.TreeSet;
public class UVA136 {
	public static void main(String args[]){
		TreeSet<Integer> allUglyNumbers=new TreeSet();
		allUglyNumbers.add(1);
		while(allUglyNumbers.size()<1500){
			int cal2=allUglyNumbers.higher(allUglyNumbers.last()/2)*2;
			int cal3=allUglyNumbers.higher(allUglyNumbers.last()/3)*3;
			int cal5=allUglyNumbers.higher(allUglyNumbers.last()/5)*5;
			allUglyNumbers.add(Math.min(cal2, Math.min(cal3, cal5)));
		}
		System.out.println("The 1500'th ugly number is "+allUglyNumbers.last()+".");
		
	}
}
