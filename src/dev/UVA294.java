package dev;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class UVA294 {
	public static int primeCounts(long n){
		int count=1;
		Hashtable<Integer,Integer> result=new Hashtable();
		Integer k=2;
		if(n==2){
			if(result.containsKey(2)){
				result.put(2, result.get(2)+1);
			}else{
				result.put(2, 1);
			}
		}else{
			while(k<=n){
				if(n%k==0){
					if(!result.containsKey(k)){
						result.put(k, 1);
					}else{
						result.put(k, result.get(k)+1);
					}
					n=n/k;
				} else{
					k++;
				}
			}
		}
		Iterator it=result.keySet().iterator();
		while(it.hasNext()){
			count*=(result.get(it.next())+1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int N=cin.nextInt();
		for(int i=0;i<N;i++){
			long from=cin.nextLong(),to=cin.nextLong();
			long number=0;
			int divisor=0;
			for(long j=from;j<=to;j++){
				int count=primeCounts(j);
				if(count>divisor){
					divisor=count;
					number=j;
				}
			}
			System.out.printf("Between %d and %d, %d has a maximum of %d divisors.\n",from,to,number,divisor);
		}
	}
}
