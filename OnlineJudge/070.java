import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		char[] c;
		char[] front = new char[500];
		char[] back = new char[500];
		boolean check = false;
		int len;
		
		s = sc.next();
		c = s.toCharArray();
		
		if((c.length%2) == 0) {
			len = c.length;
		}
		else {
			len = c.length;
		}
		
		for(int i=0;i<len/2;i++) {
			front[i] = c[i];
		}
		if(c.length%2 != 0) {
			for(int i=c.length-1,j=0;i>len/2;i--,j++) {
				back[j] = c[i];
			}
		}
		else {
			for(int i=c.length-1,j=0;i>len/2-1;i--,j++) {
				back[j] = c[i];
			}
		}
		for(int i=0;i<front.length;i++) {
			if(front[i] != back[i]) {
				System.out.println("no");
				check = true;
				break;
			}
		}
		if(check == false) {
			System.out.println("yes");
		}
	}
}
