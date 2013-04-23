package release;

import java.util.Scanner;

public class UVA272 {
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int first=1;
		while(cin.hasNext()){
			String line=cin.nextLine();
			for(int i=0;i<line.length();i++){
				if(line.charAt(i)=='"'){
					if(first==1){
						System.out.printf("``");
					}else{
						System.out.printf("''");
					}
					first=1-first;
				}else{
					System.out.printf("%c",line.charAt(i));
				}
			}
			System.out.printf("\n");	
		}
	}

}
