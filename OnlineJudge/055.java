import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n_s;
		char[] n_c = new char[33];
		int tmp, sum = 0;
		
		n_s = sc.next();
		n_c = n_s.toCharArray();
		
		for(int i=0;i<n_s.length();i++) {
			tmp = Character.getNumericValue(n_c[i]);
			sum += tmp;
		}
		System.out.println(sum);
	}
}
