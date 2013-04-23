/**
 * Project Name:UVA
 * File Name:UVA156.java
 * Package Name:dev
 * Created Date:2012-12-31����3:44:36
 * Modified Date: 2012-12-31����3:44:36
 * Copyright (c) 2012, caoyaqiang0410@gmail.com All Rights Reserved.
 * 
 */
package release;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * ClassName:UVA156 <br/>
 * date: 2012-12-31����3:44:36 <br/>
 * @author CAO Yaqiang
 * @author caoyaqiang0410@gmail.com
 * @version 
 */
public class UVA156 {

	/**
	 * main:<br/>
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		ArrayList<String> raw=new ArrayList();
		Hashtable<String,Integer> parse=new Hashtable();
		while(cin.hasNext()){
			String line=cin.nextLine();
			if(line.equals("#")){
				//����������
				break;
			}else{
				String[] words=line.trim().split(" ");
				//�������Ŀո񣬼���Ԫ���ַ����б����봦���ֵ�
				for(int i=0;i<words.length;i++){
					words[i]=words[i].trim();
					if (words[i].length()>0){
						raw.add(words[i]);
						//Сд��ð�����򣬴�С���󣬣������ֵ�
						String newword=sortlower(words[i]);
						if (parse.containsKey(newword)){
							parse.put(newword,parse.get(newword) +1);
						}else{
							parse.put(newword,1);
						}
					}
				}
			}
		}
		
		//��������ȥ�������ֶ�εĵ���
		Enumeration e=parse.keys();
		while(e.hasMoreElements()){
			String key=(String) e.nextElement();
			if(parse.get(key)>1){
				parse.remove(key);
			}
		}
		//������Ž��,ѡ����Щ����һ�εĵ���
		ArrayList<String> result=new ArrayList();
		for(int i=0;i<raw.size();i++){
			String newword=sortlower(raw.get(i));
			if(parse.containsKey(newword)){
				result.add(raw.get(i));
			}
		}
		//�Գ���һ�εĵ��ʰ���ĸ��˳������
		for(int i=0;i<result.size()-1;i++){
			for(int j=i+1;j<result.size();j++){
				if(result.get(i).compareTo(result.get(j))>0){
					String tmp=result.get(i);
					result.set(i, result.get(j));
					result.set(j, tmp);
				}
			}
		}
		//������
		for(int i=0;i<result.size();i++){
			System.out.printf("%s\n", result.get(i));
		}
	}

	/**
	 * sortlower:<br/>
	 * @param string
	 * @return
	 */
	private static String sortlower(String words) {
		char[] word=words.toLowerCase().toCharArray();
		for(int j=0;j<word.length-1;j++){
			for(int k=j+1;k<word.length;k++){
				if(word[j]>word[k]){
					char tmp=word[j];
					word[j]=word[k];
					word[k]=tmp;
				}
			}
		}
		//�ַ�����ת�ַ���
		String newword=new String(word);
		return newword;
	}

}
