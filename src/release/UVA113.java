package release;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
public class UVA113 {
	public static BigInteger pow(int a,int b){
		BigInteger result=new BigInteger("1");
		BigInteger abig=new BigInteger(Integer.toString(a));
		for(int i=1;i<=b;i++){
			result=result.multiply(abig);
		}
		return result;
	}
	public static void main(String args[]) throws Exception{
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			BigDecimal n=cin.nextBigDecimal();
			BigInteger p=cin.nextBigInteger();
			MathContext mc = new MathContext(1000,RoundingMode.HALF_DOWN);
			BigDecimal logeP = new BigDecimal(Math.log10(p.doubleValue()) ,mc);
			logeP=logeP.divide(n,mc);
			int result=(int) Math.pow(10, logeP.doubleValue());
			int nint=n.intValue();
			if(p.equals(pow(result,nint))){
				System.out.println(result);
			}
			if(p.equals(pow(result-1,nint))){
				System.out.println(result-1);
			}
			if(p.equals(pow(result+1,nint))){
				System.out.println(result+1);
			}
		}
	}

}
