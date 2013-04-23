package dev;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class UVA123 {
	static ArrayList wordsIgnored=new ArrayList();
	static ArrayList titles=new ArrayList();
	static Hashtable keyWords=new Hashtable();
	
	public static void readIn(){
		boolean isTitle=false;
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String line=cin.nextLine().trim();
			if(line.equals("::")){
				isTitle=true;
				continue;
			}else{
				if(isTitle==false){
					if(!wordsIgnored.contains(line.toLowerCase())){
						wordsIgnored.add(line.toLowerCase());
						System.out.println(wordsIgnored);
					}
				}else{
					titles.add(line.split(" "));
					System.out.println(titles);
				}
			}
		}
	}
	
	public static void findKeywords(){
		
	} 
	
	public static void main(String[] args) {
		readIn();	
	}

}
