import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ip;
		String ip_;
		int index, index_pre, n = 0, i = 0;
		boolean check = false;
		
		ip = sc.next();
		
		index = 0;
		for(i=0;i<3;i++) {
			if(i==0) {
				index_pre = 0;
			}
			else {
				index_pre = index+1;
			}
			index = ip.indexOf(".", index+1);
			ip_ = ip.substring(index_pre, index);
			n = Integer.parseInt(ip_);
			if(n != 123) {
				System.out.println("gg");
				check = true;
				break;
			}
		}
		if(i == 3) {
		ip_ = ip.substring(index+1, ip.length());
		n = Integer.parseInt(ip_);
		if(check == false) {
			if(n >= 2 && n <= 255) {
				System.out.println("winable!");
			}
			else {
				System.out.println("gg");
			}
		}
		}
	}
}
