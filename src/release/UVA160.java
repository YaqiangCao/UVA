package release;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
public class UVA160 {
	private static ArrayList primes(int x){
		ArrayList<Integer> primes=new ArrayList();
		int k=2;
		if(x==2){
			primes.add(x);
		}else{
			while(k<=x){
				if(x%k==0){
					primes.add(k);
					x=x/k;
				}else{
					k++;
				}
			}
		}
		return primes;
	}
	
	private static ArrayList allPrimes(int x){
		ArrayList<Integer> allPrimes=new ArrayList();
		for(int i=2;i<=x;i++){
			int flag=1;
			for(int j=2;j<i;j++){
				if(i%j==0){
					flag=0;
					break;
				}
			}
			if(flag==1){
				allPrimes.add(i);
			}
		}
		//System.out.println(allPrimes);
		return allPrimes;
	}
	
	private static void printResult(int n, Hashtable<Integer, Integer> result) {
		//对Hahtable对其key进行从小到达排序
		Set keysSet=result.keySet();
		ArrayList keysList=new ArrayList(keysSet);
		for(int i=0;i<keysList.size()-1;i++){
			for(int j=i+1;j<keysList.size();j++){
				if((Integer) keysList.get(i)>(Integer) keysList.get(j)){
					int tmp=(Integer) keysList.get(j);
					keysList.set(j, keysList.get(i));
					keysList.set(i, tmp);
				}
			}
		}
		System.out.printf("%3d! =", n);
		for(int i=0;i<keysList.size();i++){
			if((i+1)%15==1 && i!=0){
				System.out.printf("\n      %3d", result.get(keysList.get(i)));
			}else{
				System.out.printf("%3d", result.get(keysList.get(i)));
			}
		}
		System.out.printf("\n");
	}
	
	private static void primeSplit(int n){
		Hashtable<Integer,Integer> result=new Hashtable();
		for(int i=2;i<=n;i++){
			ArrayList primes=primes(i);
			Iterator it=primes.iterator();
			while(it.hasNext()){
				int key=(Integer) it.next();
				if (result.containsKey(key)){
					result.put(key, 1+result.get(key));
				}else{
					result.put(key, 1);
				}
			}
		}
		//System.out.println(result);
		//遍历存储结果的Hashtable�?��的质因数
		Iterator it=result.keySet().iterator();
		int maxPrime=2;
		while(it.hasNext()){
			int key=(Integer)it.next();
			if(key>=maxPrime){
				maxPrime=key;
			}
		}
		//System.out.print("max prime is "+maxPrime);
		ArrayList allPrimes=allPrimes(maxPrime);
		Iterator it1=allPrimes.iterator();
		while(it1.hasNext()){
			int key=(Integer) it1.next();
			int value=0;
			if (!result.containsKey(key)){
				result.put(key, value);
			}
		}
		printResult(n,result);
	}
	
	

	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			int N=cin.nextInt();
			if(N==0){
				return;
			}else{
				primeSplit(N);
			}
		}
	}
}
