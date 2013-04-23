package release;
import java.util.Scanner;
public class UVA494 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String line=cin.nextLine().toString().toLowerCase();
			int count=0;
			for(int i=0;i<line.length()-1;i++){
				if( ((line.charAt(i)-'z'<=0) && (line.charAt(i)-'a'>=0)) && ((line.charAt(i+1)-'z'>0) || (line.charAt(i+1)-'a'<0)) ){
					count+=1;
				}
			}
			System.out.println(count);
		}
	}
}
