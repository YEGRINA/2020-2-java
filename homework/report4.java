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
		System.out.println("1. 이름: " + name);
		if(n == 1) return;
		System.out.println("2. 생년월일: " + birth);
		if(n == 2) return;
		System.out.println("3. 출생지: " + hometown);
		if(n == 3) return;
	}
		
}

public class report4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		String name, birth, hometown;
		Human h = null;
		
		System.out.print("입력 항목은 몇 개입니까? ");
		n = sc.nextInt();
		
		input : {
			System.out.print("입력1(이름) = ");
			name = sc.next();
			if(n == 1) {
				h = new Human(name);
				break input;
			}
			sc.nextLine(); // \n 제거
			System.out.print("입력2(생년월일) = ");
			birth = sc.nextLine();
			if(n == 2) {
				h = new Human(name, birth);
				break input;
			}
			System.out.print("입력3(출생지) = ");
			hometown = sc.nextLine();
			if(n == 3) {
				h = new Human(name, birth, hometown);
				break input;
			}
		}
		System.out.println("\n객체가 생성되었습니다.\n");
		
		System.out.println("객체정보");
		h.output(n);
		
		sc.close();
		
	}
}
