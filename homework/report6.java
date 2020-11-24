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
		System.out.println("�� ģ�� �߰��ϱ� 1");
		System.out.println("ģ�� ��� ���� 2");
		System.out.print("���� 3\n�Է� : ");
		n = sc.nextInt();
		
		if(n == 1) {
			System.out.print("�̸� : ");
			name = sc.next();
			System.out.print("������� : ");
			birth = sc.next();
			System.out.print("��ȭ��ȣ : ");
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
			System.out.println("�̸� : "+f.name);
			System.out.println("������� : "+f.birth);
			System.out.println("��ȭ��ȣ : "+f.num);
			System.out.println();
			ois.close();
		}
		else if(n == 3) break;
		}
		
	}
}
