import java.util.*;

class Human
{
	private String name;
	private String birth;
	private String hometown;
	
	public Human(String name) {
		this.name = name;
	}
	public Human(String name, String birth) {
		this.name = name;
		this.birth = birth;
	}
	public Human(String name, String birth, String hometown) {
		this.name = name;
		this.birth = birth;
		this.hometown = hometown;
	}
	
	public void output(int n) {
		System.out.println("1. �̸�: " + name);
		if(n == 1) return;
		System.out.println("2. �������: " + birth);
		if(n == 2) return;
		System.out.println("3. �����: " + hometown);
		if(n == 3) return;
	}
		
}

public class report4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		String name, birth, hometown;
		Human h = null;
		
		System.out.print("�Է� �׸��� �� ���Դϱ�? ");
		n = sc.nextInt();
		
		input : {
			System.out.print("�Է�1(�̸�) = ");
			name = sc.next();
			if(n == 1) {
				h = new Human(name);
				break input;
			}
			sc.nextLine(); // \n ����
			System.out.print("�Է�2(�������) = ");
			birth = sc.nextLine();
			if(n == 2) {
				h = new Human(name, birth);
				break input;
			}
			System.out.print("�Է�3(�����) = ");
			hometown = sc.nextLine();
			if(n == 3) {
				h = new Human(name, birth, hometown);
				break input;
			}
		}
		System.out.println("\n��ü�� �����Ǿ����ϴ�.\n");
		
		System.out.println("��ü����");
		h.output(n);
		
		sc.close();
		
	}
}
