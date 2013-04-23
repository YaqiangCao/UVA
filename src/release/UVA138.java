package release;
//reference:http://hi.baidu.com/aekdycoin/item/a45f7c37850e5b9db80c03d1
//(2n+1)^2-8k^2=1
//n=(m-1)/1
//m^2-8k^2=1
//m(0)=3,k(0)=1,m(1)=17,k(1)=6
//m(i+1)=3*m(i)+8*k(i),k(i+1)=m(i)+3*k(i)

public class UVA138 {
	public static void main(String args[]) throws Exception{
		int count=0;
		int m=17,k=6,newm=0,newk=0;
		while(count<10){
			System.out.printf("%10d%10d\n",k,(m-1)/2);
			count=count+1;
			newm=3*m+8*k;
			newk=m+3*k;
			m=newm;
			k=newk;
		}
	}
}
