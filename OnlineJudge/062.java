import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] pizza = {"bulgogi", "cheeze", "sweet potato"};
		String[] choose = new String[2];
		
		for(int i=0;i<2;i++) {
			choose[i] = sc.nextLine();
			for(int j=0;j<3;j++) {
				if(choose[i].equals(pizza[j])) {
					pizza[j] = null;
				}
			}
		}
		for(int i=0;i<3;i++) {
			if(pizza[i] != null) {
				System.out.println(pizza[i]);
			}
		}
		
	}
}
