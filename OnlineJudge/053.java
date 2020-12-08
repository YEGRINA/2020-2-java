import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, len = 0, count = 0, c_len;
		String[] str;
		
		n = sc.nextInt();
		str = new String[n];
     	char[] c_ = new char[n];
		char[] c = new char[n];
		
		for(int i=0;i<n;i++) {
			str[i] = sc.next();
			if(str[i].length() > len) {
				len = str[i].length();
			}
		}
		while(count < len) {
			for(int i=0;i<n;i++) {
				c = str[i].toCharArray();
				c_len = c.length;
				if(count < c_len) {
					c_[i] = c[count];
				}
				else {
					c_[i] = '.';
				}
			}
			System.out.println(c_);
			count++;
		}
	}	
}
