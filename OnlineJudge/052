import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, count = 0;
		String[] str;
		char[] c_;
		char[] c;
		
		n = sc.nextInt();
		str = new String[n];
		c = new char[n];
		c_ = new char[n];
		
		for(int i=0;i<n;i++) {
			str[i] = sc.next();
		}
		while(count < n) {
			for(int i=0;i<n;i++) {
				c = str[i].toCharArray();
				c_[i] = c[count];
			}
			System.out.println(c_);
			count++;
		}
	}	
}
