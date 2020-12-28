import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		String m, m_ = null;
		int tmp = 0, sum = 0, len;
		
		n = sc.nextInt();
		m = sc.next();
		len = m.length();
		
		for(int i=2;i<=36;i++) {
			sum = 0;
			for(int j=len-1;j>=0;j--) {
				m_ = m.substring(len-j-1, len-j);
				if(m_.equals("0")) tmp = 0;
				else if(m_.equals("1")) tmp = 1;
				else if(m_.equals("2")) tmp = 2;
				else if(m_.equals("3")) tmp = 3;
				else if(m_.equals("4")) tmp = 4;
				else if(m_.equals("5")) tmp = 5;
				else if(m_.equals("6")) tmp = 6;
				else if(m_.equals("7")) tmp = 7;
				else if(m_.equals("8")) tmp = 8;
				else if(m_.equals("9")) tmp = 9;
				else if(m_.equals("a")) tmp = 10;
				else if(m_.equals("b")) tmp = 11;
				else if(m_.equals("c")) tmp = 12;
				else if(m_.equals("d")) tmp = 13;
				else if(m_.equals("e")) tmp = 14;
				else if(m_.equals("f")) tmp = 15;
				else if(m_.equals("g")) tmp = 16;
				else if(m_.equals("h")) tmp = 17;
				else if(m_.equals("i")) tmp = 18;
				else if(m_.equals("j")) tmp = 19;
				else if(m_.equals("k")) tmp = 20;
				else if(m_.equals("l")) tmp = 21;
				else if(m_.equals("m")) tmp = 22;
				else if(m_.equals("n")) tmp = 23;
				else if(m_.equals("o")) tmp = 24;
				else if(m_.equals("p")) tmp = 25;
				else if(m_.equals("q"))	tmp = 26;
				else if(m_.equals("r")) tmp = 27;
				else if(m_.equals("s")) tmp = 28;
				else if(m_.equals("t")) tmp = 29;
				else if(m_.equals("u")) tmp = 30;
				else if(m_.equals("v")) tmp = 31;
				else if(m_.equals("w")) tmp = 32;
				else if(m_.equals("x")) tmp = 33;
				else if(m_.equals("y")) tmp = 34;
				else if(m_.equals("z")) tmp = 35;
				sum += tmp*(int)Math.pow(i, j);
			}
			if(sum == n) {
				System.out.println(i);
				break;
			}
		}
	}
}
