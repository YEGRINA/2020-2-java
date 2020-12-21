import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money, price;
		int buyMilk, plusMilk, blkMilk_q, blkMilk_r, totalMilk;
		
		money = sc.nextInt();
		price = sc.nextInt();
		buyMilk = money/price;
		plusMilk = buyMilk/2;
		blkMilk_q = (buyMilk+plusMilk)/5;
		blkMilk_r = (buyMilk+plusMilk)%5 + blkMilk_q;
		totalMilk = buyMilk + plusMilk + blkMilk_q;
		
		while((blkMilk_q >= 5) || (blkMilk_r >= 5)) {
			blkMilk_q = blkMilk_r/5;
			blkMilk_r = (blkMilk_r%5) + blkMilk_q;
			totalMilk += blkMilk_q;
		}	
		System.out.println(totalMilk);
	}
}
