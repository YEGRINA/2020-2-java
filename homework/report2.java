// 현금 계산 프로그램

import java.util.Scanner;
public class report2 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int money, fiftyThousand, tenThousand, oneThousand;
		int fiveHundred, oneHundred, ten, one;
		
		System.out.print("금액을 입력하세요:");
		money=sc.nextInt();
		
		fiftyThousand=money/50000;
		money%=50000;
		tenThousand=money/10000;
		money%=10000;
		oneThousand=money/1000;
		money%=1000;
		fiveHundred=money/500;
		money%=500;
		oneHundred=money/100;
		money%=100;
		ten=money/10;
		one=money%10;
		
		System.out.println("오만원:"+fiftyThousand);
		System.out.println("만원:"+tenThousand);
		System.out.println("천원:"+oneThousand);
		System.out.println("오백원:"+fiveHundred);
		System.out.println("백원:"+oneHundred);
		System.out.println("십원:"+ten);
		System.out.println("일원:"+one);

	}

}
