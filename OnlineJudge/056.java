import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String marble_s;
		char[] marble_c = new char[6];
		char[] tmp = new char[6];
		int n;
		
		marble_s = sc.next();
		marble_c = marble_s.toCharArray();
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			tmp[2] = marble_c[0];
			tmp[4] = marble_c[1];
			tmp[1] = marble_c[2];
			tmp[0] = marble_c[3];
			tmp[5] = marble_c[4];
			tmp[3] = marble_c[5];
			 
			marble_c[0] = tmp[0];
			marble_c[1] = tmp[1];
			marble_c[2] = tmp[2];
			marble_c[3] = tmp[3];
			marble_c[4] = tmp[4];
			marble_c[5] = tmp[5];
		}
		for(int i=0;i<6;i++) {
			System.out.print(marble_c[i]);
		}
	}
}
