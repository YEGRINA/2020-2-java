import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		String str;
		char[] c;
		
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			str = sc.next();
			if(str.length() > 10) {
				c = str.toCharArray();
				System.out.print(c[0]);
				System.out.print(str.length());
				System.out.println(c[str.length()-1]);
			}
			else {
				System.out.println(str);
			}
		}
		
	}	
}
