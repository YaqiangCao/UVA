package dev;

import java.util.*;

public class UVA195 {
	public static ArrayList getNext(ArrayList<Integer> line){
		int flag=0;
		int i=line.size()-1;
		for(;i>=1;i--){
			if(line.get(i-1)<line.get(i)){
				flag=1;
				break;
			}
		}
		if(flag==0){
			line.clear();
		}else{
			int k=i-1;
			for(int j=line.size()-1;j>k;j--){
				if(line.get(j)>line.get(k)){
//					System.out.println(line);
					Collections.swap(line, k, j);
					Collections.sort(line.subList(k+1, line.size()));
//					System.out.println(line);
					//This break is IMPORTANT!!
					break;
				}
			}
		}
		return line;
		
	}
	 
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		int N=cin.nextInt();
		Hashtable<String,Integer> char2int=new Hashtable();
		Hashtable<Integer,String> int2char=new Hashtable<Integer, String>();
		for(char a='A';a<='Z';a++){
			char2int.put(String.valueOf(a), 2*(a-'A')+1);
			int2char.put(2*(a-'A')+1,String.valueOf(a));
		}
		for(char a='a';a<='z';a++){
			char2int.put(String.valueOf(a),2*(a-'a'+1));
			int2char.put(2*(a-'a'+1),String.valueOf(a));
		}
		while(N>0){
			char[] line=cin.nextLine().trim().toCharArray();
			if(line.length==0){
				continue;
			}
			ArrayList<Integer> newline=new ArrayList();
			for(int i=0;i<line.length;i++){
				newline.add(char2int.get(String.valueOf(line[i])));
			}
			Collections.sort(newline);
			String out="";
			while(true){
				for(int i=0;i<newline.size();i++){
					out=out+int2char.get(newline.get(i));
				}
				out=out+"\n";
				newline=getNext(newline);
				if(newline.isEmpty()==true){
					break;
				}
			}
			System.out.printf("%s",out);
			N=N-1;
		}
	}
}
