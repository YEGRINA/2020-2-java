import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		boolean[] locker = new boolean[103];
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;i*j<=100;j++) {
				if(locker[i*j] == false) {
					locker[i*j] = true;
				}
				else {
					locker[i*j] = false;
				}
			}
		}
		if(locker[m] == false) {
			System.out.println("close");
		}
		else {
			System.out.println("open");
		}
	}
}
