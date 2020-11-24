import java.util.*;
import java.io.*;

class Friends implements Serializable {
	public String name;
	public String birth;
	public String num;
	
	public Friends(String name, String birth, String num) {
		this.name = name;
		this.birth = birth;
		this.num = num;
	}
}

public class report6 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n;
		String name, birth, num;
		
		while(true) {
		System.out.println("새 친구 추가하기 1");
		System.out.println("친구 목록 보기 2");
		System.out.print("종료 3\n입력 : ");
		n = sc.nextInt();
		
		if(n == 1) {
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("생년월일 : ");
			birth = sc.next();
			System.out.print("전화번호 : ");
			num = sc.next();
			Friends nf = new Friends(name, birth, num);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("friends.txt"));
			oos.writeObject(nf);
			oos.close();
			System.out.println();
		}
		if(n == 2) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("friends.txt"));
			Friends f = (Friends)ois.readObject();
			System.out.println("이름 : "+f.name);
			System.out.println("생년월일 : "+f.birth);
			System.out.println("전화번호 : "+f.num);
			System.out.println();
			ois.close();
		}
		else if(n == 3) break;
		}
		
	}
}
