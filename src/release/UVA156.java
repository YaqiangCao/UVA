/**
 * Project Name:UVA
 * File Name:UVA156.java
 * Package Name:dev
 * Created Date:2012-12-31下午3:44:36
 * Modified Date: 2012-12-31下午3:44:36
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
 * date: 2012-12-31下午3:44:36 <br/>
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
				//输入结束标记
				break;
			}else{
				String[] words=line.trim().split(" ");
				//提出多余的空格，加入元素字符串列表，加入处理字典
				for(int i=0;i<words.length;i++){
					words[i]=words[i].trim();
					if (words[i].length()>0){
						raw.add(words[i]);
						//小写，冒泡排序，从小到大，，存入字典
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
		
		//整理结果，去除掉出现多次的单词
		Enumeration e=parse.keys();
		while(e.hasMoreElements()){
			String key=(String) e.nextElement();
			if(parse.get(key)>1){
				parse.remove(key);
			}
		}
		//用来存放结果,选出那些出现一次的单词
		ArrayList<String> result=new ArrayList();
		for(int i=0;i<raw.size();i++){
			String newword=sortlower(raw.get(i));
			if(parse.containsKey(newword)){
				result.add(raw.get(i));
			}
		}
		//对出现一次的单词按字母表顺序排序
		for(int i=0;i<result.size()-1;i++){
			for(int j=i+1;j<result.size();j++){
				if(result.get(i).compareTo(result.get(j))>0){
					String tmp=result.get(i);
					result.set(i, result.get(j));
					result.set(j, tmp);
				}
			}
		}
		//输出结果
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
		//字符数组转字符串
		String newword=new String(word);
		return newword;
	}

}
