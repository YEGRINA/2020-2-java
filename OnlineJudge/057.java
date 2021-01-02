import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, index, index_, left = 0, right = 0;
		String suk;
		
		suk = sc.next();
		n = sc.nextInt();
		m = sc.nextInt();
		
		if((index = suk.indexOf("=", 0)) >= 0) {
			index_ = suk.indexOf("(", 0);
			right = index_ - index;
		}
		if((index = suk.indexOf(")", 0)) >= 0) {
			index_ = suk.indexOf("@", 1);
			left = index_ - index - 1;
		}
		
		System.out.print("@");
		for(int i=0;i<(m+right);i++) {
			System.out.print("=");
		}
		System.out.print("(^-^)");
		for(int i=0;i<(n+left);i++) {
			System.out.print("=");
		}
		System.out.println("@");
	}
}
