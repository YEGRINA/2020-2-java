import java.util.*;

class Pair {
	public int x;
	public int y;
	
	public Pair() {}
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, x, y;
		int up = 0, right = 0;
		Pair[] p = new Pair[100];
		
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			p[i] = new Pair(x, y);
			if(p[right].x < p[i].x) {
				right = i;
			}
			else if(p[right].x == p[i].x) {
				if(p[right].y < p[i].y) {
					right = i;
				}
			}
			if(p[up].y < p[i].y) {
				up = i;
			}
			else if(p[up].y == p[i].y) {
				if(p[up].x < p[i].x) {
					up = i;
				}
			}
		}
		System.out.println(p[right].x +" "+p[right].y);
		System.out.println(p[up].x +" "+p[up].y);
	}
}
