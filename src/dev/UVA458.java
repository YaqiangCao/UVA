import java.util.Scanner;

public class UVA458 {
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			char[] c=cin.nextLine().toCharArray();
			for(int i=0;i<c.length;i++){
				if(c[i]==10){
					System.out.println();
				}else{
					System.out.print((char)(c[i]-7));
				}
			}
		}
	}
}
