import java.util.Scanner;
public class report2 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int money, fiftyThousand, tenThousand, oneThousand;
		int fiveHundred, oneHundred, ten, one;
		
		System.out.print("�ݾ��� �Է��ϼ���:");
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
		
		System.out.println("������:"+fiftyThousand);
		System.out.println("����:"+tenThousand);
		System.out.println("õ��:"+oneThousand);
		System.out.println("�����:"+fiveHundred);
		System.out.println("���:"+oneHundred);
		System.out.println("�ʿ�:"+ten);
		System.out.println("�Ͽ�:"+one);

	}

}
